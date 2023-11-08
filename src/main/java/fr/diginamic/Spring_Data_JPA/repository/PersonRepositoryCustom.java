package fr.diginamic.Spring_Data_JPA.repository;


public interface PersonRepositoryCustom {
    void deletePeopleWithoutAnimals();
    void createManyEntity(int count);
}
