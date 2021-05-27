
package com.reuben.payoneerchallenge.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Networks {

    @SerializedName("applicable")
    @Expose
    private List<Applicable> applicable = null;

    public List<Applicable> getApplicable() {
        return applicable;
    }

    public void setApplicable(List<Applicable> applicable) {
        this.applicable = applicable;
    }

}
