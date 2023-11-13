package fr.diginamic.SpringMVC.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import fr.diginamic.SpringMVC.model.Person;
import fr.diginamic.SpringMVC.service.PersonService;

@RestController
@RequestMapping("/api/person")
public class PersonRestController {
    @Autowired
    private PersonService personService;

    @GetMapping()
    public List<Person> findAll(){
        return personService.findAll();
    } 
    
}
