package com.example.cookingstepbystep.model;

public class Fried {
    int id;
    String name;
    String Ingredients;
    String Vitamin;
    String VideoUrl;
    String thumbnailUrl;

    public Fried(int id, String name, String ingredients, String vitamin, String videoUrl, String thumbnailUrl) {
        this.id = id;
        this.name = name;
        Ingredients = ingredients;
        Vitamin = vitamin;
        VideoUrl = videoUrl;
        this.thumbnailUrl = thumbnailUrl;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIngredients() {
        return Ingredients;
    }

    public String getVitamin() {
        return Vitamin;
    }

    public String getVideoUrl() {
        return VideoUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
}
