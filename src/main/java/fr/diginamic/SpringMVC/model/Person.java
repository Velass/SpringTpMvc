package fr.diginamic.SpringMVC.model;



import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;


@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int age ;

    private String firstname;

    private String lastname;


    @ManyToMany
    @JoinTable(name = "person_animals", joinColumns = @JoinColumn(name = "person_id" ),inverseJoinColumns = @JoinColumn(name = "animals_id")) // Nom de la table de jointure si nécessaire
    @Column(name = "id_person")
    private List<Animal> animals;


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }


    public String getFirstname() {
        return firstname;
    }


    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }


    public String getLastname() {
        return lastname;
    }


    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public List<Animal> getAnimals() {
        return animals;
    }


    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }


    @Override
    public String toString() {
        return "Person [id=" + getId() + ", age=" + getAge() + ", firstname=" + getFirstname() + ", lastname=" + getLastname()
                + ", animals=" + getAnimals() + "]";
    }

    
}
