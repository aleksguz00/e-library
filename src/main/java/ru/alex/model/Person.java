package ru.alex.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private int id;

    @NotEmpty(message = "Name couldn't be empty")
    private String name;

    @Min(value = 0, message = "Age couldn't be less then 0")
    private int age;

    @NotEmpty(message = "Email couldn't be empty")
    @Email(message = "Email has an invalid format")
    private String email;

    private List<Book> books = new ArrayList<>();

    public Person() {}

    public Person(int id, String name, int age, String email, List<Book> books) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.books = books;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
