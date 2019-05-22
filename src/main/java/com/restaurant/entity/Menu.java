package com.restaurant.entity;

public class Menu {
    private int id;
    private String name;
    private String type;
    private double price;
    private double publicMark;
    private double privateMark;
    private String season;

    public Menu() {
    }

    public Menu(int id, String name, String type, double price, double publicMark, double privateMark, String season) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.publicMark = publicMark;
        this.privateMark = privateMark;
        this.season = season;
    }

    public Menu(Integer id, String name, String type, Double price, String season) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.season = season;
    }

    public Menu(String name, String type, double price, String season) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.season = season;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public double getPublicMark() {
        return publicMark;
    }

    public void setPublicMark(double publicMark) {
        this.publicMark = publicMark;
    }

    public double getPrivateMark() {
        return privateMark;
    }

    public void setPrivateMark(double privateMark) {
        this.privateMark = privateMark;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price='" + price + '\'' +
                ", season='" + season + '\'' +
                '}';
    }
}
