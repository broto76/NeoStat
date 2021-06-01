package com.broto.neostat.viewmodels;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.broto.neostat.datahandler.DataHandler;
import com.broto.neostat.models.ChartResultData;
import com.broto.neostat.models.ResultModel;
import com.broto.neostat.models.SummaryResultData;

import java.io.Serializable;

public class MainViewModel extends AndroidViewModel {

    private final MutableLiveData<ResultModel> mResult;

    public MainViewModel(Application application) {
        super(application);
        mResult = new MutableLiveData<>();
    }

    public LiveData<ResultModel> getSummaryLiveData() {
        return mResult;
    }

    public void fetchAsteroidData(String start, String end) {
        DataHandler.getInstance(getApplication()).fetchAsteroidDetails(start, end, mResult);
    }

}
