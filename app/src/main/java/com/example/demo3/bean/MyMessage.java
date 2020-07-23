package com.example.demo3.bean;

import com.google.gson.annotations.SerializedName;

public class MyMessage {
    @SerializedName("id")
    private int id;
    @SerializedName("description")
    private String description;
    @SerializedName("image_url")
    private String imageUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesription() {
        return description;
    }

    public void setDesription(String desription) {
        this.description = desription;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", desription='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
