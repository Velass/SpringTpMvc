package fr.diginamic.SpringMVC.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.SpringMVC.model.Species;
import fr.diginamic.SpringMVC.repository.SpeciesRepository;

@RestController
@RequestMapping("/species")
public class SpeciesController {

    @Autowired
    private SpeciesRepository speciesRepository;

    @GetMapping("/species")
    public List<Species> getAllSpecies() {
        return speciesRepository.findAll();
    }

    @GetMapping("/species/{id}")
    public String initUpdate(@PathVariable("id") Integer id, Model model) {
        Optional<Species> species = speciesRepository.findById(id);
        if (species.isPresent()) {
            model.addAttribute(species.get());
            return "update_species";
        }
        return "error";
    }

    @GetMapping("/species/create")
    public String initCreate(Model model) {
        model.addAttribute(new Species());
        return "create_species";
    }
}
