package com.PetStore.APItesting.model;

public class Tags {

    private Integer id;
    private String name;




    public Tags(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Tags() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
