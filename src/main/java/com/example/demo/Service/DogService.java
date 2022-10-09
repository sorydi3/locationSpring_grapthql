package com.example.demo.service;

import java.util.*;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Dog;
import com.example.demo.exception.CNotFoundException;
import com.example.demo.repository.DogRepository;

@Service
public class DogService {
    @Autowired
    private DogRepository dogRepository;

    @PostConstruct
    public void fillDataBase() {
        dogRepository.save(new Dog("Bulldog", "Bulldog", 3, "England"));
        dogRepository.save(new Dog("Husky", "Husky", 5, "Alaska"));
        dogRepository.save(new Dog("Poodle", "Poodle", 2, "France"));
    }



    public List<String> retrieveDogsName() {
        List<String> dogsName = new ArrayList<>();
        dogRepository.findAll().forEach(dog -> dogsName.add(dog.getName()));
        return dogsName;
    }

    public List<String> retrieveDogsBreed() {
        List<String> dogsBreed = new ArrayList<>();
        dogRepository.findAll().forEach(dog -> dogsBreed.add(dog.getBreed()));
        return dogsBreed;
    }

    public void deleteById(Long id) {
        dogRepository.deleteById(id);
    }

    public void updateDog(Dog dog) {
        dogRepository.save(dog);
    }

    public Dog retreaveDogByID(Long id) {
        Optional<Dog> dog = dogRepository.findById(id);
        if (dog.isPresent()) {
            return dog.get();
        } else {
            throw new CNotFoundException("Dog not found",id);
        }
    }

    public void addDog(Dog dog) {
        dogRepository.save(dog);
    }
}
