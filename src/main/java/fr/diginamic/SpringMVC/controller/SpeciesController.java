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
import fr.diginamic.springmvc.model.Species;
import fr.diginamic.springmvc.repository.SpeciesRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/species")
public class SpeciesController {

    @Autowired
    private SpeciesRepository speciesRepository;

    @GetMapping
    public String getAllSpecies(Model model) {
       List<Species> species = speciesRepository.findAll();
       model.addAttribute("species", species);
        return "species/speciesVue";
    }

    @GetMapping("/{id}")
    public String initUpdate(@PathVariable("id") Integer id, Model model) {
        Optional<Species> species = speciesRepository.findById(id);
        if (species.isPresent()) {
            model.addAttribute("species",species.get());
            return "species/speciesVueCreate";
        }
        return "error";
    }

    @GetMapping("/create")
    public String initCreate(Model model) {
        model.addAttribute("species",new Species());
        return "species/speciesVueCreate";
    }

        @PostMapping()
        @Valid
    public String createOrUpdate(@Valid Species species, BindingResult result) {
        if (result.hasErrors()) {
            return "species/speciesVueCreate";
        }
        this.speciesRepository.save(species);
        return "redirect:/species";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer specieslId) {
        Optional<Species> speciesToDelete = this.speciesRepository.findById(specieslId);
        speciesToDelete.ifPresent(specie -> this.speciesRepository.delete(specie));
        return "redirect:/species";
    }
}
