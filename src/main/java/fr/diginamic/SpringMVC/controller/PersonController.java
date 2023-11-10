package fr.diginamic.SpringMVC.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.diginamic.SpringMVC.model.Animal;
import fr.diginamic.SpringMVC.model.Person;
import fr.diginamic.SpringMVC.model.Species;
import fr.diginamic.SpringMVC.repository.AnimalRepository;
import fr.diginamic.SpringMVC.repository.PersonRepository;

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
    public String createOrUpdate(Person person) {
        this.personRepository.save(person);
        return "redirect:/person";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer personlId) {
        Optional<Person> personToDelete = this.personRepository.findById(personlId);
        personToDelete.ifPresent(person -> this.personRepository.delete(person));
        return "redirect:/person";
    }
}
