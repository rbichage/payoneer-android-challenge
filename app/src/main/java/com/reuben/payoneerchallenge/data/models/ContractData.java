
package com.reuben.payoneerchallenge.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContractData {

    @SerializedName("PAGE_ENVIRONMENT")
    @Expose
    private String pageEnvironment;
    @SerializedName("JAVASCRIPT_INTEGRATION")
    @Expose
    private String javascriptIntegration;
    @SerializedName("PAGE_BUTTON_LOCALE")
    @Expose
    private String pageButtonLocale;

    public String getPageEnvironment() {
        return pageEnvironment;
    }

    public void setPageEnvironment(String pageEnvironment) {
        this.pageEnvironment = pageEnvironment;
    }

    public String getJavascriptIntegration() {
        return javascriptIntegration;
    }

    public void setJavascriptIntegration(String javascriptIntegration) {
        this.javascriptIntegration = javascriptIntegration;
    }

    public String getPageButtonLocale() {
        return pageButtonLocale;
    }

    public void setPageButtonLocale(String pageButtonLocale) {
        this.pageButtonLocale = pageButtonLocale;
    }

}
