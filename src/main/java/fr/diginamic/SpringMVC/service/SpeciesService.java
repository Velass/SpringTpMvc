package fr.diginamic.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fr.diginamic.springmvc.model.Person;
import fr.diginamic.springmvc.model.Species;
import fr.diginamic.springmvc.repository.SpeciesRepository;
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

    public Page<Species> findAll(Pageable pageable) {
        return speciesRepository.findAll(pageable);
    }

}
