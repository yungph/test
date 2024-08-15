package com.crudoperations.crudoperations.models;

public class IdRequest {
    private String id;
    private int discount;
    private String phoneNumber;
    private String status;

    
    public IdRequest() {}

    public IdRequest(String id, int discount,String phoneNumber) {
        this.id = id;
        this.discount = discount;
        this.phoneNumber=phoneNumber;
        
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
    

