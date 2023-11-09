package fr.diginamic.SpringMVC.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.SpringMVC.model.Person;
import fr.diginamic.SpringMVC.repository.PersonRepository;

@RestController
@RequestMapping("/person")
public class PersonController {
      @Autowired
    private PersonRepository personRepository;

    @GetMapping("/person")
    public List<Person> getAllSpecies() {
        return personRepository.findAll();
    }

    @GetMapping("/person/{id}")
    public String initUpdate(@PathVariable("id") Integer id, Model model) {
        Optional<Person> species = personRepository.findById(id);
        if (species.isPresent()) {
            model.addAttribute(species.get());
            return "update_species";
        }
        return "error";
    }

    @GetMapping("/person/create")
    public String initCreate(Model model) {
        model.addAttribute(new Person());
        return "create_species";
    }
}
