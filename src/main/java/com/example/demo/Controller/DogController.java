package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Dog;
import com.example.demo.service.DogService;


import java.util.*;

@RestController
public class DogController {

   @Autowired
   private DogService dogService;

   @GetMapping("/")
    @ResponseBody
    public List<String> nothing() {
        return dogService.retrieveDogsBreed();
    }

    @GetMapping("/breeds")
    @ResponseBody
    public List<String> retrieveDogsBreed() {
        return dogService.retrieveDogsBreed();
    }

    @GetMapping("/names")
    @ResponseBody
    public List<String> retrieveDogsName() {
        return dogService.retrieveDogsName();
    }

    @GetMapping("/dog/{id}")
    @ResponseBody
    public Dog retrieveDogsID(@PathVariable Long id) {
        return dogService.retreaveDogByID(id);
    }

    @GetMapping("/add")
    @ResponseBody
    public void addDog(@RequestParam String name, @RequestParam String breed, @RequestParam int age, @RequestParam String origin) {
        dogService.addDog(new Dog(name, breed, age, origin));
    }
   
}
