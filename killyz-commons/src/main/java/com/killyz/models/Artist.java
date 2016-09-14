package com.killyz.models;

public class Artist {

    private long _id;
    private String firstName;
    private String lastName;
    private String email;
    private String portfolio;
    private PaymentPlatform paymentPlatform;
    private PaymentMethod paymentMethod;
    private String billingAddress;
    private Long modelCount;

    public Artist() {
        this.modelCount = 0L;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    public PaymentPlatform getPaymentPlatform() {
        return paymentPlatform;
    }

    public void setPaymentPlatform(PaymentPlatform paymentPlatform) {
        this.paymentPlatform = paymentPlatform;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Long getModelCount() {
        return modelCount;
    }

    public void setModelCount(Long modelCount) {
        this.modelCount = modelCount;
    }

    public void increaseModelCount() {
        this.modelCount++;
    }
}
