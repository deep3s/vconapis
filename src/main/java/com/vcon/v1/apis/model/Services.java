package com.vcon.v1.apis.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "services")
public class Services {
    @Id
    @Column
    private int service_id;
    @Column
    private String name;
    @Column
    private String duration;
    @Column
    private String price;
    @Column
    private String description;


    public int getId() {
        return service_id;
    }

    public void setId(int id) {
        this.service_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String address) {
        this.duration = duration;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String nearby) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String nearby) {
        this.description = description;
    }
}
