package com.example.demo.resolver;

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demo.entity.Dog;
import com.example.demo.exception.CNotFoundException;
import com.example.demo.repository.DogRepository;

@Component
public class Query implements GraphQLQueryResolver {
    @Autowired
    DogRepository dogRepository;
 
    public Query(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Iterable<Dog> findAllDogs() {
        return dogRepository.findAll();
    }

    public String findDogBreedById(Long id) {
        Optional<Dog> dog = dogRepository.findById(id);

        if (dog.isPresent()) {
            return dog.get().getBreed();
        } else {
            throw new CNotFoundException("Dog Breed not found with id=" + id, id);
        }
    }

    public List<String> findAllDogNames() {
        List<String> names = new ArrayList<>();
        dogRepository.findAll().forEach(dog -> names.add(dog.getName()));
        return names;
    }

    public List<String> findDogBreeds() {
        List<String> breeds = new ArrayList<>();
        dogRepository.findAll().forEach(dog -> breeds.add(dog.getBreed()));
        return breeds;
    }

    public boolean deleteDogBreed(String breed){
        List<Dog> dogs = dogRepository.findAllByBreed(breed);
        if(dogs.size() == 0) {
            throw new CNotFoundException("Dog Breed not found with breed=" + breed, breed);
        }
        dogRepository.deleteAll(dogs);
        return true;
    }
}
