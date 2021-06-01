
package com.broto.neostat.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MissDistance implements Serializable
{

    @SerializedName("astronomical")
    @Expose
    private String astronomical;
    @SerializedName("lunar")
    @Expose
    private String lunar;
    @SerializedName("kilometers")
    @Expose
    private String kilometers;
    @SerializedName("miles")
    @Expose
    private String miles;
    private final static long serialVersionUID = 1342845005325297274L;

    public String getAstronomical() {
        return astronomical;
    }

    public void setAstronomical(String astronomical) {
        this.astronomical = astronomical;
    }

    public String getLunar() {
        return lunar;
    }

    public void setLunar(String lunar) {
        this.lunar = lunar;
    }

    public String getKilometers() {
        return kilometers;
    }

    public void setKilometers(String kilometers) {
        this.kilometers = kilometers;
    }

    public String getMiles() {
        return miles;
    }

    public void setMiles(String miles) {
        this.miles = miles;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(MissDistance.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("astronomical");
        sb.append('=');
        sb.append(((this.astronomical == null)?"<null>":this.astronomical));
        sb.append(',');
        sb.append("lunar");
        sb.append('=');
        sb.append(((this.lunar == null)?"<null>":this.lunar));
        sb.append(',');
        sb.append("kilometers");
        sb.append('=');
        sb.append(((this.kilometers == null)?"<null>":this.kilometers));
        sb.append(',');
        sb.append("miles");
        sb.append('=');
        sb.append(((this.miles == null)?"<null>":this.miles));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
