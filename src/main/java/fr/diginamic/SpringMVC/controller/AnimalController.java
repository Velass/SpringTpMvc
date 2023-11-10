package fr.diginamic.SpringMVC.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.diginamic.SpringMVC.model.Animal;
import fr.diginamic.SpringMVC.model.Species;
import fr.diginamic.SpringMVC.repository.AnimalRepository;
import fr.diginamic.SpringMVC.repository.SpeciesRepository;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/animal")
public class AnimalController {
    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private SpeciesRepository speciesRepository;

    @GetMapping
    public String getAllSpecies(Model model) {
        List<Animal> animal = animalRepository.findAll();
        model.addAttribute("animal", animal);
        return "animal/animalVue";

    }

    @GetMapping("/{id}")
    public String initUpdate(@PathVariable("id") Integer id, Model model) {
        Optional<Animal> animal = animalRepository.findById(id);
        List<Species> speciesList = speciesRepository.findAllOrderedByCommonNameAsc();
        model.addAttribute("speciesList", speciesList);
        if (animal.isPresent()) {
            model.addAttribute("animal", animal);
            return "animal/animalVueCreate";
        }
        return "error";
    }

    @GetMapping("/create")
    public String initCreate(Model model) {
        model.addAttribute("animal", new Animal());
        List<Species> speciesList = speciesRepository.findAllOrderedByCommonNameAsc();
        model.addAttribute("speciesList", speciesList);
        return "animal/animalVueCreate";
    }

    @PostMapping()
    @Valid
    public String createOrUpdate(@Valid Animal animalItem, BindingResult result) {
        if (result.hasErrors()) {
            return "animalVueCreate";
        }
        this.animalRepository.save(animalItem);
        return "redirect:/animal";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer animalId) {
        Optional<Animal> animalToDelete = this.animalRepository.findById(animalId);
        animalToDelete.ifPresent(animal -> this.animalRepository.delete(animal));
        return "redirect:/animal";
    }

}
