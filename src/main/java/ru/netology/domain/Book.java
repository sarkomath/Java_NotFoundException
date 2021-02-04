package ru.netology.domain;

public class Book extends Product{
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String author;

    public Book() {
        super();
    }

    public Book(int id, int count, String name, String author) {
        super(id, count, name);
        this.author = author;
    }
}


