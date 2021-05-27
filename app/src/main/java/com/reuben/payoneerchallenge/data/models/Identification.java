
package com.reuben.payoneerchallenge.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Identification {

    @SerializedName("longId")
    @Expose
    private String longId;
    @SerializedName("shortId")
    @Expose
    private String shortId;
    @SerializedName("transactionId")
    @Expose
    private String transactionId;

    public String getLongId() {
        return longId;
    }

    public void setLongId(String longId) {
        this.longId = longId;
    }

    public String getShortId() {
        return shortId;
    }

    public void setShortId(String shortId) {
        this.shortId = shortId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

}
