package com.broto.neostat.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ChartResultData implements Serializable {
    private final ArrayList<ChartResultItem> mChartData;

    public ChartResultData() {
        mChartData = new ArrayList<>();
    }

    public void addData(ChartResultItem item) {
        mChartData.add(item);
    }

    public List<ChartResultItem> getResult() {
        return mChartData;
    }

    public void clear() {
        mChartData.clear();
    }

}
