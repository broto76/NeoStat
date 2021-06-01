
package com.broto.neostat.models;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NearEarthObject implements Serializable
{

    @SerializedName("links")
    @Expose
    private Links__1 links;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("neo_reference_id")
    @Expose
    private String neoReferenceId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("nasa_jpl_url")
    @Expose
    private String nasaJplUrl;
    @SerializedName("absolute_magnitude_h")
    @Expose
    private Double absoluteMagnitudeH;
    @SerializedName("estimated_diameter")
    @Expose
    private EstimatedDiameter estimatedDiameter;
    @SerializedName("is_potentially_hazardous_asteroid")
    @Expose
    private Boolean isPotentiallyHazardousAsteroid;
    @SerializedName("close_approach_data")
    @Expose
    private List<CloseApproachDatum> closeApproachData = null;
    @SerializedName("is_sentry_object")
    @Expose
    private Boolean isSentryObject;
    private final static long serialVersionUID = -3359179750488942996L;

    public Links__1 getLinks() {
        return links;
    }

    public void setLinks(Links__1 links) {
        this.links = links;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNeoReferenceId() {
        return neoReferenceId;
    }

    public void setNeoReferenceId(String neoReferenceId) {
        this.neoReferenceId = neoReferenceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNasaJplUrl() {
        return nasaJplUrl;
    }

    public void setNasaJplUrl(String nasaJplUrl) {
        this.nasaJplUrl = nasaJplUrl;
    }

    public Double getAbsoluteMagnitudeH() {
        return absoluteMagnitudeH;
    }

    public void setAbsoluteMagnitudeH(Double absoluteMagnitudeH) {
        this.absoluteMagnitudeH = absoluteMagnitudeH;
    }

    public EstimatedDiameter getEstimatedDiameter() {
        return estimatedDiameter;
    }

    public void setEstimatedDiameter(EstimatedDiameter estimatedDiameter) {
        this.estimatedDiameter = estimatedDiameter;
    }

    public Boolean getIsPotentiallyHazardousAsteroid() {
        return isPotentiallyHazardousAsteroid;
    }

    public void setIsPotentiallyHazardousAsteroid(Boolean isPotentiallyHazardousAsteroid) {
        this.isPotentiallyHazardousAsteroid = isPotentiallyHazardousAsteroid;
    }

    public List<CloseApproachDatum> getCloseApproachData() {
        return closeApproachData;
    }

    public void setCloseApproachData(List<CloseApproachDatum> closeApproachData) {
        this.closeApproachData = closeApproachData;
    }

    public Boolean getIsSentryObject() {
        return isSentryObject;
    }

    public void setIsSentryObject(Boolean isSentryObject) {
        this.isSentryObject = isSentryObject;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(NearEarthObject.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("links");
        sb.append('=');
        sb.append(((this.links == null)?"<null>":this.links));
        sb.append(',');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("neoReferenceId");
        sb.append('=');
        sb.append(((this.neoReferenceId == null)?"<null>":this.neoReferenceId));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("nasaJplUrl");
        sb.append('=');
        sb.append(((this.nasaJplUrl == null)?"<null>":this.nasaJplUrl));
        sb.append(',');
        sb.append("absoluteMagnitudeH");
        sb.append('=');
        sb.append(((this.absoluteMagnitudeH == null)?"<null>":this.absoluteMagnitudeH));
        sb.append(',');
        sb.append("estimatedDiameter");
        sb.append('=');
        sb.append(((this.estimatedDiameter == null)?"<null>":this.estimatedDiameter));
        sb.append(',');
        sb.append("isPotentiallyHazardousAsteroid");
        sb.append('=');
        sb.append(((this.isPotentiallyHazardousAsteroid == null)?"<null>":this.isPotentiallyHazardousAsteroid));
        sb.append(',');
        sb.append("closeApproachData");
        sb.append('=');
        sb.append(((this.closeApproachData == null)?"<null>":this.closeApproachData));
        sb.append(',');
        sb.append("isSentryObject");
        sb.append('=');
        sb.append(((this.isSentryObject == null)?"<null>":this.isSentryObject));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
