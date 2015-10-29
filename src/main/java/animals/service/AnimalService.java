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
            case AnimalService.SHEEP:
                animal = new Sheep();
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

    public Animal findOne(Integer id) {
        return animalRepository.findOne(id);
    }

    @Transactional
    public Animal findOneWithProduce(Integer id) {
        Animal animal = animalRepository.findOne(id);
        animal.setProduce(produceRepository.findByAnimal(animal));

        return animal;
    }

    @Transactional
    public void createProduce(Produce produce) {
        produceRepository.save(produce);
    }
}
