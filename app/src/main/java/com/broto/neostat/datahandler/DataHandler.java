package com.broto.neostat.datahandler;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.broto.neostat.models.ChartResultData;
import com.broto.neostat.models.ChartResultItem;
import com.broto.neostat.models.NasaResponseModel;
import com.broto.neostat.models.NearEarthObject;
import com.broto.neostat.models.ResultModel;
import com.broto.neostat.models.SummaryResultData;
import com.broto.neostat.utility.Constants;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataHandler {

    private static DataHandler mInstance;
    private Context mContext;

    private final RetrofitService mRetrofitService;

    private double mCurrentMaxSpeed = 0.0d;
    private String mIdFastestAsteroid = "";

    private double mCurrentMinDistance = Double.MAX_VALUE;
    private String mIdClosestAsteroid = "";

    private double averageAsteroidSize = 0.0d;
    private double totalSizeOfAll = 0.0d;

    private final ChartResultData mChartResultData;

    public static DataHandler getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new DataHandler(context);
        }
        return mInstance;
    }

    private DataHandler(Context context) {
        mContext = context;
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(Constants.RETROFIT_READ_TIMEOUT_SEC, TimeUnit.SECONDS)
                .connectTimeout(Constants.RETROFIT_CONN_TIMEOUT_SEC, TimeUnit.SECONDS)
                .build();
        mRetrofitService = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
                .create(RetrofitService.class);
        mChartResultData = new ChartResultData();
    }

    public void fetchAsteroidDetails(String start, String end,
                                     MutableLiveData<ResultModel> mData) {
        mRetrofitService.getAsteroidDetails(start, end, Constants.NASA_TOKEN).enqueue(
                new Callback<NasaResponseModel>() {
                    @Override
                    public void onResponse(Call<NasaResponseModel> call,
                                           Response<NasaResponseModel> data) {
                        NasaResponseModel response = data.body();
                        if (data.code() != 200) {
                            Log.d("DataHandler", "Result Code NOT OK. Abort");
                            Intent intent = new Intent(Constants.INTENT_REMOTE_DATA_FETCH_ERROR);
                            intent.putExtra(Constants.REMOTE_DATA_FETCH_ERROR_MESSAGE,
                                    "Response Code: " + data.code());
                            mContext.sendBroadcast(intent);
                            return;
                        }
                        //Log.d("DataHandler", "Response: " + response);
                        Log.d("DataHandler", "Total: " + response.getElementCount());
                        processAsteroidData(response
                                .getNearEarthObjects(), response.getElementCount());
                        mData.setValue(new ResultModel(
                                mChartResultData, new SummaryResultData(
                                        setPrecision(mCurrentMaxSpeed, 2),
                                        mIdFastestAsteroid,
                                        setPrecision(mCurrentMinDistance, 2),
                                        mIdClosestAsteroid,
                                        setPrecision(averageAsteroidSize, 2)
                                )
                        ));
                    }

                    @Override
                    public void onFailure(Call<NasaResponseModel> call, Throwable t) {
                        Log.d("DataHandler","Error: " + t.getMessage());
                        Intent intent = new Intent(Constants.INTENT_REMOTE_DATA_FETCH_ERROR);
                        intent.putExtra(Constants.REMOTE_DATA_FETCH_ERROR_MESSAGE, t.getMessage());
                        mContext.sendBroadcast(intent);
                    }
                }
        );
    }

    private void processAsteroidData(Map<String, List<NearEarthObject>> list, Long count) {

        mCurrentMaxSpeed = 0.0d;
        mIdFastestAsteroid = "";

        mCurrentMinDistance = Double.MAX_VALUE;
        mIdClosestAsteroid = "";

        averageAsteroidSize = 0.0d;
        totalSizeOfAll = 0.0d;

        mChartResultData.clear();

        for (Map.Entry<String, List<NearEarthObject>> it : list.entrySet()) {
            processAsteroidDataForDate(it.getValue());
            mChartResultData.addData(new ChartResultItem(it.getKey(), it.getValue().size()));
        }
        averageAsteroidSize = totalSizeOfAll/count;
    }

    private void processAsteroidDataForDate(List<NearEarthObject> list) {
        double speed;
        double distance;
        for (NearEarthObject object: list) {


            speed = Double.parseDouble(object.getCloseApproachData()
                        .get(0).getRelativeVelocity().getKilometersPerHour());
            if (speed > mCurrentMaxSpeed) {
                mCurrentMaxSpeed = speed;
                mIdFastestAsteroid = object.getId();
            }

            distance = Double.parseDouble(object.getCloseApproachData()
                    .get(0).getMissDistance().getLunar());
            if (distance < mCurrentMinDistance) {
                mCurrentMinDistance = distance;
                mIdClosestAsteroid = object.getId();
            }

            totalSizeOfAll += (
                    (object.getEstimatedDiameter().getKilometers().getEstimatedDiameterMax() +
                            object.getEstimatedDiameter().getKilometers().getEstimatedDiameterMin())/2
            );

        }
    }

    public static double setPrecision(double val, int precision) {
        long factor = (long) Math.pow(10, precision);
        val = val * factor;
        long tmp = Math.round(val);
        return (double) tmp / factor;
    }

}
