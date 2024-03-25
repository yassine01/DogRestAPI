package me.lab.dogrestapi.controller;

import me.lab.dogrestapi.entity.Dog;
import me.lab.dogrestapi.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class DogController {

    private DogService dogService;

    @Autowired
    public void setDogService(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/api/dogs")
    public ResponseEntity<List<Dog>> getAllDogs(){
        List<Dog> list = dogService.retrieveDogs();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/api/dogs/name")
    public ResponseEntity<List<String>> getNames(){
        List<String> list = dogService.retrieveDogNames();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/api/dogs/breed")
    public ResponseEntity<List<String>> getBreeds(){
        List<String> list = dogService.retriveDogBreed();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/api/dogs/origin")
    public ResponseEntity<List<String>> getOrigins(){
        List<String> list = dogService.retrieveDogOrigins();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/api/breed/{dogId}")
    public ResponseEntity<String> getBreedById(@PathVariable long dogId){
        try {
            String result = dogService.retrieveDogBreedById(dogId);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (NoSuchElementException nse) {
            return ResponseEntity.notFound().build();
        }
    }



}
