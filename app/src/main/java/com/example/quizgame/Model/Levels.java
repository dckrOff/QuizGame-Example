package com.example.quizgame.Model;

public class Levels {

    private String name;
    private String description;
    private Integer image;
    private Integer levelRating;

    public Levels(String name, String description, Integer image, Integer levelRating) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.levelRating = levelRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public Integer getLevelRating() {
        return levelRating;
    }

    public void setLevelRating(Integer levelRating) {
        this.levelRating = levelRating;
    }
}
