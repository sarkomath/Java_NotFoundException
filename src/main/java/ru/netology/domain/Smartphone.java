package ru.netology.domain;

public class Smartphone extends Product {
    public String Fabricator;

    public Smartphone() {
        super();
    }

    public Smartphone(int id, int count, String name, String fabricator) {
        super(id, count, name);
        Fabricator = fabricator;
    }

    public Smartphone(String fabricator) {
        Fabricator = fabricator;
    }

    public String getFabricator() {
        return Fabricator;
    }

    public void setFabricator(String fabricator) {
        Fabricator = fabricator;
    }
}
