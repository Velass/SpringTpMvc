package fr.diginamic.springmvc.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.diginamic.springmvc.enums.Sex;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String color;
    @NotBlank
    private String name;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @ManyToMany(mappedBy = "animals")
    @JsonIgnore
    private List<Person> persons; 
    
    @ManyToOne
    @JoinColumn(name = "species_id") 
    @NotNull
    private Species species; 

    public Animal() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    @Override
    public String toString() {
        String personsString = "null";
        if (persons != null && !persons.isEmpty()) {
            personsString = "[";
            for (Person person : persons) {
                personsString += person.getFirstname() + ", ";
            }
            personsString = personsString.substring(0, personsString.length() - 2) + "]";
        }
    
        String speciesString = (species != null) ? species.getCommonName() : "null";
    
        return "Animal [id=" + id +
               ", color=" + color +
               ", name=" + name +
               ", sex=" + sex +
               ", persons=" + personsString +
               ", species=" + speciesString +
               "]";
    }



}
