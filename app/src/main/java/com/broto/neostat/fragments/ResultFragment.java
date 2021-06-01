package com.broto.neostat.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.broto.neostat.R;
import com.broto.neostat.databinding.FragmentResultBinding;
import com.broto.neostat.models.ChartResultData;
import com.broto.neostat.models.ChartResultItem;
import com.broto.neostat.models.ResultModel;
import com.broto.neostat.models.SummaryResultData;
import com.broto.neostat.utility.Constants;
import com.softmoore.android.graphlib.Graph;
import com.softmoore.android.graphlib.Label;
import com.softmoore.android.graphlib.Point;

public class ResultFragment extends Fragment {

    private FragmentResultBinding binding;
    private ChartResultData mChartData;
    private SummaryResultData mSummary;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (getArguments() != null) {
            ResultModel model = (ResultModel) getArguments().getSerializable(Constants.KEY_RESULT_DATA);
            mChartData = model.mChartData;
            mSummary = model.mSummary;
            for (ChartResultItem item: mChartData.getResult()) {
                Log.d("ResultFragment","Date: " + item.date + " Count: " + item.count);
            }
        }
        binding = FragmentResultBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        Point[] points = new Point[mChartData.getResult().size()];
        Label[] labels = new Label[mChartData.getResult().size()];
        Log.d("ResultFragment","No of points: " + points.length);

        for (int i = 0; i<mChartData.getResult().size(); ++i) {
            Log.d("ResultFragment", "Adding " + i + " Data: " + mChartData.getResult().get(i).count);
            points[i] = new Point(i + 1, mChartData.getResult().get(i).count);
            labels[i] = new Label(i + 1, "" + (i + 1));
        }
        Graph graph = new Graph.Builder()
                .setWorldCoordinates(-2, 10, -5, 25)
                .setYTicks(new double[]{5, 10, 15, 20})
                .setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight))
                .setXLabels(labels)
                .addLineGraph(points, getResources().getColor(R.color.colorPrimaryAccent))
                .build();
        binding.graphView.setGraph(graph);

        populateSummaryViews();
    }


    private void populateSummaryViews() {
        binding.tvFastestId.setText(mSummary.mIdFastestAsteroid);
        binding.tvFastestSpeed.setText(mSummary.mCurrentMaxSpeed + " kmph");
        binding.tvClosestId.setText(mSummary.mIdClosestAsteroid);
        binding.tvClosestDistance.setText(mSummary.mCurrentMinDistance + " lunar");
        binding.tvAverageSize.setText(mSummary.averageAsteroidSize + " km");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}