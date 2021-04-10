package com.example.RecycleViewPlanets;

public class Data {
    private String name;
    private int size;
    private int image;

    Data (String name, int size, int image){
        this.name = name;
        this.size = size;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public int getImage() {
        return image;
    }
}
