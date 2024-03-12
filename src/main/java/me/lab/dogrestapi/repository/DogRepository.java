package me.lab.dogrestapi.repository;

import me.lab.dogrestapi.entity.Dog;
// JpaRepository has more advanced jpa/crud operations than crudRepo..
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DogRepository extends CrudRepository<Dog, Long> {

    @Query("SELECT d.breed from Dog d")
    List<String> findAllBreeds();

    @Query("SELECT d.breed from Dog d where d.id = :id")
    String findBreedById(Long id);

    @Query("SELECT d.name from Dog d")
    List<String> findAllNames();

    @Query("SELECT d.origin from Dog d")
    List<String> findAllOrigins();



}
