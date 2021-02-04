package ru.netology.domain;

public class Product {
    private int id;
    private int count;
    private String name;

    public Product(int id, int count, String name) {
        this.id = id;
        this.count = count;
        this.name = name;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}






