package fr.diginamic.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fr.diginamic.springmvc.exception.EntityToCreateHasAnIdException;
import fr.diginamic.springmvc.model.Animal;
import fr.diginamic.springmvc.repository.AnimalRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class AnimalService {

    @Autowired
    AnimalRepository animalRepository;

    public List<Animal> findAll() {
        return animalRepository.findAll();

    }

    public Animal findById(Integer id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID : " + id + " introuvable"));

    }

    public Animal createAnimal(@Valid Animal createAnimal) {
        if (createAnimal.getId() != 0) {
            throw new EntityToCreateHasAnIdException("présence d’un ID ");
        }
        return animalRepository.save(createAnimal);
    }

    public Animal updateAnimal(@Valid Animal updateAnimal) {
        boolean idInupdateAnimal = animalRepository.existsById(updateAnimal.getId());
        if (updateAnimal.getId() == 0) {
            throw new EntityToCreateHasAnIdException("non-présence d’un ID ");
        }
        if (idInupdateAnimal != false) {
            return animalRepository.save(updateAnimal);
        }
        throw new EntityNotFoundException("ID : " + updateAnimal.getId() + " introuvable");
    }

    public Animal deleteAnimal(Integer id) {
        Animal animalToDelete = animalRepository.findById(id).orElse(null);
        if (animalToDelete != null) {
            animalRepository.deleteById(id);
        }
        return animalToDelete;
    }

    public Page<Animal> findAll(Pageable pageable) {
        return animalRepository.findAll(pageable);
    }

}
