package com.example.demo.mutator;

import org.springframework.stereotype.Component;

import com.example.demo.repository.DogRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.demo.entity.Dog;
import com.example.demo.exception.CNotFoundException;
import java.util.*;

@Component
public class Mutator implements GraphQLMutationResolver{
    DogRepository dogRepository;

    public Dog newDog(String name, String breed, Integer age, String origin) {
        Dog dog = new Dog(name, breed, age, origin);
        dogRepository.save(dog);
        return dog;
    }

    public boolean deleteDog(Long id) {
        dogRepository.deleteById(id);
        return true;
    }

    public Dog updateDogName(String newName, Long id) {
        Optional<Dog> dog = dogRepository.findById(id);
        if (dog.isPresent()) {
            Dog newDog = dog.get();
            newDog.setName(newName);
            dogRepository.save(newDog);
            return newDog;
        } else {
            throw new CNotFoundException("Dog not found with id=" + id, id);
        }
    }
}
