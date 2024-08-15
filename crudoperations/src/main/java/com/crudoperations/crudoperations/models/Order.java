package com.crudoperations.crudoperations.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "`orders`")
public class Order {
    @Id
    private String order_id;
    private String userName;
    private String userPhone;
    @ManyToOne
    @JoinColumn(name = "requested_package_id")
    private Package requestedPackage;
    private String status; 
    
    public Order(){};
    
    public Order(String order_id, String userName, String userPhone, Package requestedPackage,String status) {
        this.order_id = order_id;
        this.userName = userName;
        this.userPhone = userPhone;
        this.requestedPackage = requestedPackage;
        this.status=status;
        //PENDING CANCELLED CONFIRMED

    }
    


    public String getOrder_id() {
        return order_id;
    }
    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserPhone() {
        return userPhone;
    }
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
    public Package getRequestedPackage() {
        return requestedPackage;
    }
    public void setRequestedPackage(Package requestedPackage) {
        this.requestedPackage = requestedPackage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    


    
}
