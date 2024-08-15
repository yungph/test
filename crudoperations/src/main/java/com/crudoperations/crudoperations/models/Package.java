package com.crudoperations.crudoperations.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "`package`")
public class Package {
    
    @Id
    private String id;
    
    String title;

    @Column(columnDefinition = "TEXT")
    String description;
    
    int price;

    @JsonProperty("isTopDeal")
    @Column(name = "is_top_deal")
    boolean topDeal;

    int discount;

    @JsonProperty("imageUrl")
    @Column(name = "image_url")
    String imageUrl;

    public Package() {}

    public Package(String title, String description, int price, boolean isTopDeal, int discount, String imageUrl) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.topDeal = isTopDeal;
        this.discount = discount;
        this.imageUrl = imageUrl;
    }
    
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    
    @JsonProperty("isTopDeal")
    public boolean isTopDeal() {
        return topDeal;
    }
    public void setTopDeal(boolean isTopDeal) {
        this.topDeal = isTopDeal;
    }
    public int getDiscount() {
        return discount;
    }
    public void setDiscount(int discount) {
        this.discount = discount;
    }
    
    @JsonProperty("imageUrl")
    public String getImgurl() {
        return imageUrl;
    }
    public void setImgurl(String imgurl) {
        this.imageUrl = imgurl;
    }

    

}
