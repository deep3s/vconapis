package com.vcon.v1.apis.model;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "salon")
public class Salon {
    @Id
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String nearby;
    @Column(name = "image_urls")
    private String imageUrls;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNearby() {
        return nearby;
    }

    public void setNearby(String nearby) {
        this.nearby = nearby;
    }

    public String getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(String imageUrls) {
        this.imageUrls = imageUrls;
    }
}
