package fr.diginamic.SpringMVC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.SpringMVC.model.Species;
import fr.diginamic.SpringMVC.repository.SpeciesRepository;
import jakarta.validation.Valid;

@Service
public class SpeciesService {

    @Autowired
    SpeciesRepository speciesRepository;

    public List<Species> findAll() {
        return speciesRepository.findAll();

    }

    public Species findById(Integer id) {
        return speciesRepository.findById(id).orElse(null);

    }

    public Species createSpecies(@Valid Species createSpecies){
        return speciesRepository.save(createSpecies);
    }

    public Species updateSpecies(@Valid Species updateSpecies){
        return speciesRepository.save(updateSpecies);
    }

    public Species deleteSpecies(Integer id){
        Species speciesToDelete = speciesRepository.findById(id).orElse(null);
        if (speciesToDelete!= null) {
            speciesRepository.deleteById(id);
        }
        return speciesToDelete;
    }

}
