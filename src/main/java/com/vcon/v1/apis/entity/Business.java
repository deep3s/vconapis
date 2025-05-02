package com.vcon.v1.apis.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "businesses")
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "business_id")
    private Long id;

    @Column(name = "business_name", nullable = false)
    private String name;

    /*@Column(name = "description")
    private String description;*/

    @Column(name = "owner_id", nullable = false)
    private Long ownerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
*/
    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}