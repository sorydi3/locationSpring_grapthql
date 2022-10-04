package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dog")
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String breed;
    private int age;
    private String origin;

    public Dog() {
    }


    public Dog(long id, String name, String breed, int age, String origin) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.origin = origin;
    }


    public Dog(String name, String breed, int age, String origin) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.origin = origin;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return this.breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
