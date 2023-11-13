package fr.diginamic.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.springmvc.model.Person;
import fr.diginamic.springmvc.repository.PersonRepository;
import jakarta.validation.Valid;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();

    }

    public Person findById(Integer id) {
        return personRepository.findById(id).orElse(null);

    }

    public Person createPerson(@Valid Person createPerson){
        return personRepository.save(createPerson);
    }

    public Person updatePerson(@Valid Person updatePerson){
        return personRepository.save(updatePerson);
    }

    public Person deletePerson(Integer id){
        Person personToDelete = personRepository.findById(id).orElse(null);
        if (personToDelete!= null) {
            personRepository.deleteById(id);
        }
        return personToDelete;
    }

}
