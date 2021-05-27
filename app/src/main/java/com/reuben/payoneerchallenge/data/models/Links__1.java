
package com.reuben.payoneerchallenge.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links__1 {

    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("self")
    @Expose
    private String self;
    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("operation")
    @Expose
    private String operation;
    @SerializedName("validation")
    @Expose
    private String validation;

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }

}
