package me.lab.dogrestapi.service;

import me.lab.dogrestapi.entity.Dog;
import me.lab.dogrestapi.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogServiceImp implements DogService{

    @Autowired
    private DogRepository dogRepository;


    @Override
    public List<String> retriveDogBreed() {
        return dogRepository.findAllBreeds();
    }

    @Override
    public String retrieveDogBreedById(Long id) {
        return dogRepository.findBreedById(id);
    }

    @Override
    public List<String> retrieveDogNames() {
        return dogRepository.findAllNames();
    }

    @Override
    public List<String> retrieveDogOrigins() {
        return dogRepository.findAllOrigins();
    }

    @Override
    public List<Dog> retrieveDogs() {
        return (List<Dog>) dogRepository.findAll();
    }
}
