package fr.diginamic.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fr.diginamic.springmvc.exception.EntityToCreateHasAnIdException;
import fr.diginamic.springmvc.model.Species;
import fr.diginamic.springmvc.repository.SpeciesRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class SpeciesService {

    @Autowired
    SpeciesRepository speciesRepository;

    public List<Species> findAll() {
        return speciesRepository.findAll();

    }

    public Species findById(Integer id) {
        return speciesRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("ID : " + id + " introuvable"));

    }

    public Species createSpecies(@Valid Species createSpecies){
         if (createSpecies.getId() != 0) {
            throw new EntityToCreateHasAnIdException("présence d’un ID ");
        }
        return speciesRepository.save(createSpecies);
    }

    public Species updateSpecies(@Valid Species updateSpecies){
        boolean idInUpdateSpecies = speciesRepository.existsById(updateSpecies.getId());
        if (updateSpecies.getId() == 0) {
            throw new EntityToCreateHasAnIdException("non-présence d’un ID ");
        }
        if (idInUpdateSpecies != false) {
            return speciesRepository.save(updateSpecies);
        }
        throw new EntityNotFoundException("ID : " + updateSpecies.getId() + " introuvable");
    }

    public Species deleteSpecies(Integer id){
        Species speciesToDelete = speciesRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("ID : " + id + " introuvable"));
        if (speciesToDelete!= null) {
            speciesRepository.deleteById(id);
        }
        return speciesToDelete;
    }

    public Page<Species> findAll(Pageable pageable) {
        return speciesRepository.findAll(pageable);
    }

}
