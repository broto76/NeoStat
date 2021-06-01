
package com.broto.neostat.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CloseApproachDatum implements Serializable
{

    @SerializedName("close_approach_date")
    @Expose
    private String closeApproachDate;
    @SerializedName("close_approach_date_full")
    @Expose
    private String closeApproachDateFull;
    @SerializedName("epoch_date_close_approach")
    @Expose
    private Long epochDateCloseApproach;
    @SerializedName("relative_velocity")
    @Expose
    private RelativeVelocity relativeVelocity;
    @SerializedName("miss_distance")
    @Expose
    private MissDistance missDistance;
    @SerializedName("orbiting_body")
    @Expose
    private String orbitingBody;
    private final static long serialVersionUID = -5520163644494279627L;

    public String getCloseApproachDate() {
        return closeApproachDate;
    }

    public void setCloseApproachDate(String closeApproachDate) {
        this.closeApproachDate = closeApproachDate;
    }

    public String getCloseApproachDateFull() {
        return closeApproachDateFull;
    }

    public void setCloseApproachDateFull(String closeApproachDateFull) {
        this.closeApproachDateFull = closeApproachDateFull;
    }

    public Long getEpochDateCloseApproach() {
        return epochDateCloseApproach;
    }

    public void setEpochDateCloseApproach(Long epochDateCloseApproach) {
        this.epochDateCloseApproach = epochDateCloseApproach;
    }

    public RelativeVelocity getRelativeVelocity() {
        return relativeVelocity;
    }

    public void setRelativeVelocity(RelativeVelocity relativeVelocity) {
        this.relativeVelocity = relativeVelocity;
    }

    public MissDistance getMissDistance() {
        return missDistance;
    }

    public void setMissDistance(MissDistance missDistance) {
        this.missDistance = missDistance;
    }

    public String getOrbitingBody() {
        return orbitingBody;
    }

    public void setOrbitingBody(String orbitingBody) {
        this.orbitingBody = orbitingBody;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CloseApproachDatum.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("closeApproachDate");
        sb.append('=');
        sb.append(((this.closeApproachDate == null)?"<null>":this.closeApproachDate));
        sb.append(',');
        sb.append("closeApproachDateFull");
        sb.append('=');
        sb.append(((this.closeApproachDateFull == null)?"<null>":this.closeApproachDateFull));
        sb.append(',');
        sb.append("epochDateCloseApproach");
        sb.append('=');
        sb.append(((this.epochDateCloseApproach == null)?"<null>":this.epochDateCloseApproach));
        sb.append(',');
        sb.append("relativeVelocity");
        sb.append('=');
        sb.append(((this.relativeVelocity == null)?"<null>":this.relativeVelocity));
        sb.append(',');
        sb.append("missDistance");
        sb.append('=');
        sb.append(((this.missDistance == null)?"<null>":this.missDistance));
        sb.append(',');
        sb.append("orbitingBody");
        sb.append('=');
        sb.append(((this.orbitingBody == null)?"<null>":this.orbitingBody));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
