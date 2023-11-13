package fr.diginamic.SpringMVC.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import fr.diginamic.SpringMVC.model.Species;
import fr.diginamic.SpringMVC.service.SpeciesService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/species")
public class SpeciesRestController {
    @Autowired
    private SpeciesService speciesService;

    @GetMapping()
    public List<Species> findAll(){
        return speciesService.findAll();
    }

    @GetMapping("/{id}")
    public Species findById(@PathVariable("id") Integer id) {
        return speciesService.findById(id);
    }

    @PostMapping()
    public Species createSpecies(@RequestBody @Valid Species createSpecies){
       return speciesService.createSpecies(createSpecies);
    }

    @PutMapping()
    public Species updateSpecies(@RequestBody @Valid Species updateSpecies){
        return speciesService.updateSpecies(updateSpecies);
    }
    
    @DeleteMapping("/delete/{id}")
    public Species deleteSpecies(@PathVariable("id") Integer id){
        return speciesService.deleteSpecies(id);
    }
}
