package com.PetStore.APItesting.model;

import java.util.ArrayList;

public class Pet {
    private Integer id;
    private String name;
    private Category category;
    private ArrayList< String > photoUrls = new ArrayList < String > ();
    private ArrayList< Tags > tags = new ArrayList < Tags > ();
    private String status;

    public Pet() {
    }

    public Pet(Integer id, String name, Category category, String status, ArrayList< String > photoUrls, ArrayList< Tags > tags) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.status = status;
        this.photoUrls = photoUrls;
        this.tags = tags;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    public ArrayList<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(ArrayList<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public ArrayList<Tags> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tags> tags) {
        this.tags = tags;
    }
    }

