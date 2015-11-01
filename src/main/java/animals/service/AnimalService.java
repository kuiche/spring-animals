package animals.service;

import animals.entity.Produce;
import animals.entity.animal.*;
import animals.exception.AnimalTypeNotFoundException;
import animals.repository.AnimalRepository;
import animals.repository.ProduceRepository;
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
    public static final String SHEEP = "animal.sheep";
    public static final String MOUNTAIN_GOAT = "animal.mountain_goat";

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private ProduceRepository produceRepository;

    /**
     * Create an animal given a type and a name
     *
     * @param type The animal type
     * @param name The animal's name
     * @return
     * @throws AnimalTypeNotFoundException
     */
    public Animal createAnimal(String type, String name) throws AnimalTypeNotFoundException {
        Animal animal;
        // Build the correct animal
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
            case AnimalService.SHEEP:
                animal = new Sheep();
                break;
            default:
                throw new AnimalTypeNotFoundException();
        }

        // Set fields
        animal.setName(name);
        animal.setBirthDate(new Date(System.currentTimeMillis()));

        // save
        return animalRepository.save(animal);
    }

    /**
     * Find all animals
     * @return All the animals
     */
    public List<Animal> findAll() {
        return animalRepository.findAll();
    }

    /**
     * Deletes an animal given an id
     * @param id
     */
    public void delete(Integer id) {
        animalRepository.delete(id);
    }

    /**
     * Finds an animal given an id
     * @param id
     * @return The animal
     */
    public Animal findOne(Integer id) {
        return animalRepository.findOne(id);
    }

    /**
     * Given an id, finds an animal and it's associated produce
     * @param id
     * @return The animal with produce loaded
     */
    @Transactional
    public Animal findOneWithProduce(Integer id) {
        Animal animal = animalRepository.findOne(id);
        animal.setProduce(produceRepository.findByAnimal(animal));

        return animal;
    }

    /**
     * Creates a produce entry
     * @param produce
     */
    @Transactional
    public void createProduce(Produce produce) {
        produceRepository.save(produce);
    }
}
