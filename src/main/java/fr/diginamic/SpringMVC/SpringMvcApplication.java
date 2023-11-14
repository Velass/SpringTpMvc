package fr.diginamic.springmvc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

import fr.diginamic.springmvc.repository.AnimalRepository;
import fr.diginamic.springmvc.repository.PersonRepository;
import fr.diginamic.springmvc.repository.SpeciesRepository;
import jakarta.transaction.Transactional;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableScheduling
public class SpringMvcApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private SpeciesRepository speciesRepository;
	@Autowired
	private AnimalRepository animalRepository;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringMvcApplication.class, args);

	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		// Effectuez des opérations de démarrage ici
		System.out.println("L'application démarre.");

		animalRepository.findAll().forEach(System.out::println);

		personRepository.findAll().forEach(System.out::println);

		speciesRepository.findAll().forEach(System.out::println);

		// Animal test = new Animal();
		// test.setColor("bleu");
		// test.setName("bernard");
		// test.setSex(Sex.M);
		// test.setSpecies(speciesRepository.findById(2).get());
		// System.out.println(speciesRepository.findFirstByCommonName("Chat"));
		// System.out.println(speciesRepository.findByLatinNameIgnoreCase("felis
		// silvestris catus"));
		// System.out.println(personRepository.findPeopleDistinctByLastnameOrFirstname("Lamarque",
		// "Henri"));
		// System.out.println(personRepository.findByAgeGreaterThanEqual(30));
		// List <String> color = new ArrayList();
		// color.add("Noir");
		// System.out.println(animalRepository.findByColorIn(color));
		// System.out.println(animalRepository.findBySpecies(speciesRepository.findById(2).get()));

		// animalRepository.save(test);
		// animalRepository.deleteById(10);

		// System.out.println(speciesRepository.findAllOrderedByCommonNameAsc());
		// System.out.println(speciesRepository.findAllSpeciesByCommonName("Chat"));
				//System.out.println(personRepository.findAllPersonByAgeMiniAndAgeMax(20,80));
				//System.out.println(personRepository.findAllPersonByAnimal(animalRepository.findById(1)));
		
		
		//personRepository.deletePeopleWithoutAnimals();
		//personRepository.createManyEntity(2);

	}

}
