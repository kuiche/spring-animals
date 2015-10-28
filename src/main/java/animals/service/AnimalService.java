package animals.service;

import animals.entity.animal.Animal;
import animals.entity.animal.Cow;
import animals.entity.animal.Goat;
import animals.entity.animal.MountainGoat;
import animals.exception.AnimalTypeNotFoundException;
import animals.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

/**
 * Created by Sam on 2015-10-28.
 */
@Service
@Transactional
public class AnimalService {
    /*
     * Available animal types
     */
    public static final String COW = "animal.cow";
    public static final String GOAT = "animal.goat";
    public static final String MOUNTAIN_GOAT = "animal.mountain_goat";

    @Autowired
    private AnimalRepository animalRepository;

    public Animal createAnimal(String type, String name) throws AnimalTypeNotFoundException {
        Animal animal;
        switch (type) {
            case AnimalService.COW:
                animal = new Cow();
                break;
            case AnimalService.GOAT:
                animal = new Goat();
                break;
            case AnimalService.MOUNTAIN_GOAT:
                animal = new MountainGoat();
                break;
            default:
                throw new AnimalTypeNotFoundException();
        }

        animal.setName(name);
        animal.setBirthDate(new Date(System.currentTimeMillis()));

        return animalRepository.save(animal);
    }

    public List<Animal> findAll() {
        return animalRepository.findAll();
    }

    public void delete(Integer id) {
        animalRepository.delete(id);
    }
}
