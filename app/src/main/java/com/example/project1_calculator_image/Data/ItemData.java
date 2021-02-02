package com.example.project1_calculator_image.Data;

public class ItemData {

    private String Image;
    private String name;
    private String description;



    public String getImage() {
        return Image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setImage(String image) {
        Image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ItemData(String image, String name, String description) {
        Image = image;
        this.name = name;
        this.description = description;
    }
}
