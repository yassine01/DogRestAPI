package me.lab.dogrestapi.service;

import me.lab.dogrestapi.entity.Dog;

import java.util.List;

public interface DogService {

    List<String> retriveDogBreed();

    String retrieveDogBreedById(Long id);

    List<String> retrieveDogNames();

    List<String> retrieveDogOrigins();

    List<Dog> retrieveDogs();
}
