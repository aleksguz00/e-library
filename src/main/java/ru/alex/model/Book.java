package ru.alex.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public class Book {

    private int id;

    @NotEmpty(message = "Title couldn't be empty")
    private String name;

    @NotEmpty(message = "Author couldn't be empty")
    private String author;

    @Min(value = 0, message = "Incorrect year")
    private int year;

    private Person owner;

    public Book() {}

    public Book(int id, String name, String author, int year, Person owner) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.year = year;
        this.owner = owner;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
