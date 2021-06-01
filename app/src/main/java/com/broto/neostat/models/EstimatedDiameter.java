
package com.broto.neostat.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EstimatedDiameter implements Serializable
{

    @SerializedName("kilometers")
    @Expose
    private Kilometers kilometers;
    @SerializedName("meters")
    @Expose
    private Meters meters;
    @SerializedName("miles")
    @Expose
    private Miles miles;
    @SerializedName("feet")
    @Expose
    private Feet feet;
    private final static long serialVersionUID = -6053448515745997573L;

    public Kilometers getKilometers() {
        return kilometers;
    }

    public void setKilometers(Kilometers kilometers) {
        this.kilometers = kilometers;
    }

    public Meters getMeters() {
        return meters;
    }

    public void setMeters(Meters meters) {
        this.meters = meters;
    }

    public Miles getMiles() {
        return miles;
    }

    public void setMiles(Miles miles) {
        this.miles = miles;
    }

    public Feet getFeet() {
        return feet;
    }

    public void setFeet(Feet feet) {
        this.feet = feet;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(EstimatedDiameter.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("kilometers");
        sb.append('=');
        sb.append(((this.kilometers == null)?"<null>":this.kilometers));
        sb.append(',');
        sb.append("meters");
        sb.append('=');
        sb.append(((this.meters == null)?"<null>":this.meters));
        sb.append(',');
        sb.append("miles");
        sb.append('=');
        sb.append(((this.miles == null)?"<null>":this.miles));
        sb.append(',');
        sb.append("feet");
        sb.append('=');
        sb.append(((this.feet == null)?"<null>":this.feet));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
