
package com.broto.neostat.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RelativeVelocity implements Serializable
{

    @SerializedName("kilometers_per_second")
    @Expose
    private String kilometersPerSecond;
    @SerializedName("kilometers_per_hour")
    @Expose
    private String kilometersPerHour;
    @SerializedName("miles_per_hour")
    @Expose
    private String milesPerHour;
    private final static long serialVersionUID = 2724447690335381850L;

    public String getKilometersPerSecond() {
        return kilometersPerSecond;
    }

    public void setKilometersPerSecond(String kilometersPerSecond) {
        this.kilometersPerSecond = kilometersPerSecond;
    }

    public String getKilometersPerHour() {
        return kilometersPerHour;
    }

    public void setKilometersPerHour(String kilometersPerHour) {
        this.kilometersPerHour = kilometersPerHour;
    }

    public String getMilesPerHour() {
        return milesPerHour;
    }

    public void setMilesPerHour(String milesPerHour) {
        this.milesPerHour = milesPerHour;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RelativeVelocity.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("kilometersPerSecond");
        sb.append('=');
        sb.append(((this.kilometersPerSecond == null)?"<null>":this.kilometersPerSecond));
        sb.append(',');
        sb.append("kilometersPerHour");
        sb.append('=');
        sb.append(((this.kilometersPerHour == null)?"<null>":this.kilometersPerHour));
        sb.append(',');
        sb.append("milesPerHour");
        sb.append('=');
        sb.append(((this.milesPerHour == null)?"<null>":this.milesPerHour));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
