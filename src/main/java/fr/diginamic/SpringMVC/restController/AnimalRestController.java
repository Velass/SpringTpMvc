package fr.diginamic.springmvc.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import fr.diginamic.springmvc.dto.AnimalDto;
import fr.diginamic.springmvc.model.Animal;
import fr.diginamic.springmvc.service.AnimalService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/animal")
public class AnimalRestController {
    @Autowired
    private AnimalService animalService;

    @GetMapping()
    public List<Animal> findAll() {
        return animalService.findAll();
    }

    @GetMapping("/{id}")
    public Animal findById(@PathVariable("id") Integer id) {
        return animalService.findById(id);
    }

    // {
    // "color": "rouge",
    // "name": "Fido",
    // "sex": "M",
    // "species": {
    // "id": 1,
    // "commonName": "test",
    // "latinName": "test"
    // }
    // }
    @PostMapping()
    public Animal createAnimal(@RequestBody @Valid Animal createAnimal) {
        return animalService.createAnimal(createAnimal);
    }

    // {
    // "id" : 22,
    // "color": "testrouge",
    // "name": "Fido",
    // "sex": "M",
    // "species": {
    // "id": 1,
    // "commonName": "test",
    // "latinName": "test"
    // }
    // }
    @PutMapping()
    public Animal updateAnimal(@RequestBody @Valid Animal updateAnimal) {
        return animalService.updateAnimal(updateAnimal);
    }

    @DeleteMapping("/delete/{id}")
    public Animal deleteAnimal(@PathVariable("id") Integer id) {
        return animalService.deleteAnimal(id);
    }

    @GetMapping("/test")
    public String getTest() {
        return "un test";
    }

    @PostMapping("/untest")
    public void saveNull() {
        animalService.createAnimal(null);
    }

    @GetMapping("/findPage")
    public Page<AnimalDto> findPage(
            @RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize
            ) {
        return animalService.findAll(PageRequest.of(pageNumber, pageSize));
    }
}
