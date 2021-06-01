
package com.broto.neostat.models;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class NasaResponseModel implements Serializable
{

    @SerializedName("links")
    @Expose
    private Links links;
    @SerializedName("element_count")
    @Expose
    private Long elementCount;
    @SerializedName("near_earth_objects")
    @Expose
    private Map<String, List<NearEarthObject>> nearEarthObjects;
    private final static long serialVersionUID = 5600482942945172230L;

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Long getElementCount() {
        return elementCount;
    }

    public void setElementCount(Long elementCount) {
        this.elementCount = elementCount;
    }

    public Map<String, List<NearEarthObject>> getNearEarthObjects() {
        return nearEarthObjects;
    }

    public void setNearEarthObjects(Map<String, List<NearEarthObject>> nearEarthObjects) {
        this.nearEarthObjects = nearEarthObjects;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(NasaResponseModel.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("links");
        sb.append('=');
        sb.append(((this.links == null)?"<null>":this.links));
        sb.append(',');
        sb.append("elementCount");
        sb.append('=');
        sb.append(((this.elementCount == null)?"<null>":this.elementCount));
        sb.append(',');
        sb.append("nearEarthObjects");
        sb.append('=');
        sb.append(((this.nearEarthObjects == null)?"<null>":this.nearEarthObjects));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
