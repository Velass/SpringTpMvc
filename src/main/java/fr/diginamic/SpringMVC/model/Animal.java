package fr.diginamic.SpringMVC.model;

import java.util.List;

import fr.diginamic.SpringMVC.enums.Sex;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;


@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String color;
    private String name;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @ManyToMany(mappedBy = "animals") // Utilisez "animals" pour représenter la relation Many-to-Many
    private List<Person> persons; // Supposons que vous avez une classe "Person" pour représenter les personnes
    
    @ManyToOne
    @JoinColumn(name = "species_id") // Colonne de la clé étrangère vers Species
    private Species species; // Utilisez @ManyToOne pour représenter la relation Many-to-One avec Species

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
