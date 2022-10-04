package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Dog;

@Repository
public interface DogRepository extends CrudRepository<Dog, Long> {}
