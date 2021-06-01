package com.broto.neostat.models;

import java.io.Serializable;

public class ResultModel implements Serializable {

    public ChartResultData mChartData;
    public SummaryResultData mSummary;

    public ResultModel(ChartResultData mChartData, SummaryResultData mSummary) {
        this.mChartData = mChartData;
        this.mSummary = mSummary;
    }
}
