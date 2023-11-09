package fr.diginamic.SpringMVC.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.SpringMVC.model.Animal;
import fr.diginamic.SpringMVC.repository.AnimalRepository;


@RestController
@RequestMapping("/animal")
public class AnimalController {
    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping
    public List<Animal> getAllSpecies() {
        return animalRepository.findAll();
    }

    @GetMapping("/{id}")
    public String initUpdate(@PathVariable("id") Integer id, Model model) {
        Optional<Animal> animal = animalRepository.findById(id);
        if (animal.isPresent()) {
            model.addAttribute(animal.get());
            return "AnimalVue";
        }
        return "error";
    }

    @GetMapping("/create")
    public String initCreate(Model model) {
        model.addAttribute(new Animal());
        return "AnimalVue";
    }
}
