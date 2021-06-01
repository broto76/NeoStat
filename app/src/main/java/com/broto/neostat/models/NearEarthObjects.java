
package com.broto.neostat.models;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NearEarthObjects implements Serializable
{

    @SerializedName("2021-01-02")
    @Expose
    private List<NearEarthObject> NearEarthObject = null;
    private final static long serialVersionUID = -1086153217645395578L;

    public List<NearEarthObject> get20210102() {
        return NearEarthObject;
    }

    public void set20210102(List<NearEarthObject> NearEarthObject) {
        this.NearEarthObject = NearEarthObject;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(NearEarthObjects.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("_20210102");
        sb.append('=');
        sb.append(((this.NearEarthObject == null)?"<null>":this.NearEarthObject));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
