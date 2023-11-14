package fr.diginamic.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fr.diginamic.springmvc.model.Animal;
import fr.diginamic.springmvc.repository.AnimalRepository;
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

        public Page<Animal> findAll(Pageable pageable) {
        return animalRepository.findAll(pageable);
    }

}
