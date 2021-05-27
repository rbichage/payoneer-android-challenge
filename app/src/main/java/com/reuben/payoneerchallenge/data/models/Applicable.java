
package com.reuben.payoneerchallenge.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Applicable {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("method")
    @Expose
    private String method;
    @SerializedName("grouping")
    @Expose
    private String grouping;
    @SerializedName("registration")
    @Expose
    private String registration;
    @SerializedName("recurrence")
    @Expose
    private String recurrence;
    @SerializedName("redirect")
    @Expose
    private Boolean redirect;
    @SerializedName("links")
    @Expose
    private Links__1 links;
    @SerializedName("selected")
    @Expose
    private Boolean selected;
    @SerializedName("inputElements")
    @Expose
    private List<InputElement> inputElements = null;
    @SerializedName("operationType")
    @Expose
    private String operationType;
    @SerializedName("contractData")
    @Expose
    private ContractData contractData;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getGrouping() {
        return grouping;
    }

    public void setGrouping(String grouping) {
        this.grouping = grouping;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(String recurrence) {
        this.recurrence = recurrence;
    }

    public Boolean getRedirect() {
        return redirect;
    }

    public void setRedirect(Boolean redirect) {
        this.redirect = redirect;
    }

    public Links__1 getLinks() {
        return links;
    }

    public void setLinks(Links__1 links) {
        this.links = links;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public List<InputElement> getInputElements() {
        return inputElements;
    }

    public void setInputElements(List<InputElement> inputElements) {
        this.inputElements = inputElements;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public ContractData getContractData() {
        return contractData;
    }

    public void setContractData(ContractData contractData) {
        this.contractData = contractData;
    }

}
