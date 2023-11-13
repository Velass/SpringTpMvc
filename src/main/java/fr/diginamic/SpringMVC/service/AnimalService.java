package fr.diginamic.SpringMVC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.SpringMVC.model.Animal;
import fr.diginamic.SpringMVC.repository.AnimalRepository;
import jakarta.validation.Valid;

@Service
public class AnimalService {

    @Autowired
    AnimalRepository animalRepository;

    public List<Animal> findAll() {
        return animalRepository.findAll();

    }

    public Animal findById(Integer id) {
        return animalRepository.findById(id).orElse(null);

    }

    public Animal createAnimal(@Valid Animal createAnimal){
        return animalRepository.save(createAnimal);
    }

    public Animal updateAnimal(@Valid Animal updateAnimal){
        return animalRepository.save(updateAnimal);
    }

    public Animal deleteAnimal(Integer id){
        Animal animalToDelete = animalRepository.findById(id).orElse(null);
        if (animalToDelete!= null) {
            animalRepository.deleteById(id);
        }
        return animalToDelete;
    }

}
