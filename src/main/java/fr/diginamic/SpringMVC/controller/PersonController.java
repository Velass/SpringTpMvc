package fr.diginamic.springmvc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.diginamic.springmvc.model.Animal;
import fr.diginamic.springmvc.model.Person;
import fr.diginamic.springmvc.repository.AnimalRepository;
import fr.diginamic.springmvc.repository.PersonRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping
    public String getAllSpecies(Model model) {
        List<Person> person = personRepository.findAll();
        model.addAttribute("person", person);
        return "person/personVue";
    }

    @GetMapping("/{id}")
    public String initUpdate(@PathVariable("id") Integer id, Model model) {
        Optional<Person> person = personRepository.findById(id);
        List<Animal> animalsList = animalRepository.findAll();
        model.addAttribute("animalsList", animalsList);
        if (person.isPresent()) {
            model.addAttribute("person", person.get());
            return "person/personVueCreate";
        }
        return "error";
    }

    @GetMapping("/create")
    public String initCreate(Model model) {
        List<Animal> animalsList = animalRepository.findAll();
        model.addAttribute("animalsList", animalsList);
        model.addAttribute("person", new Person());
        return "person/personVueCreate";
    }

    @PostMapping()
    @Valid
    public String createOrUpdate(@Valid Person person, BindingResult result, Model model) {
        List<Animal> animalsList = animalRepository.findAll();
        model.addAttribute("animalsList", animalsList);
        if (result.hasErrors()) {
            return "person/personVueCreate";
        }
        this.personRepository.save(person);
        return "redirect:/person";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer personlId) {
        Optional<Person> personToDelete = this.personRepository.findById(personlId);
        personToDelete.ifPresent(person -> this.personRepository.delete(person));
        return "redirect:/person";
    }

    @GetMapping("/deletePeopleWithoutAnimals")
    public String deletePeopleWithoutAnimals() {
        personRepository.deletePeopleWithoutAnimals(); // Appel de votre méthode de service
        return "redirect:/person"; // Redirection vers une page après suppression
    }

    @GetMapping("/createManyEntity")
        public String createManyEntity() {
        personRepository.createManyEntity(15); // Appel de votre méthode de service
        return "redirect:/person"; // Redirection vers une page après suppression
    }
}
