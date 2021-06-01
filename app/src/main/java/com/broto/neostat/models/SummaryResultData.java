package com.broto.neostat.models;

import java.io.Serializable;

public class SummaryResultData implements Serializable {

    public double mCurrentMaxSpeed;
    public String mIdFastestAsteroid;

    public double mCurrentMinDistance;
    public String mIdClosestAsteroid;

    public double averageAsteroidSize;

    public SummaryResultData(
            double mCurrentMaxSpeed,
            String mIdFastestAsteroid,
            double mCurrentMinDistance,
            String mIdClosestAsteroid,
            double averageAsteroidSize
    ) {
        this.mCurrentMaxSpeed = mCurrentMaxSpeed;
        this.mIdFastestAsteroid = mIdFastestAsteroid;
        this.mCurrentMinDistance = mCurrentMinDistance;
        this.mIdClosestAsteroid = mIdClosestAsteroid;
        this.averageAsteroidSize = averageAsteroidSize;
    }

}
