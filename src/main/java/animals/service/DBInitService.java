package animals.service;

import animals.entity.animal.Animal;
import animals.entity.animal.Cow;
import animals.entity.Produce;
import animals.entity.animal.Goat;
import animals.entity.animal.MountainGoat;
import animals.repository.AnimalRepository;
import animals.repository.ProduceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.Date;

/**
 * Created by Sam on 2015-10-27.
 */
@Service
public class DBInitService {
    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private ProduceRepository produceRepository;

    /**
     * Seed method, used during development. Left in to "show my working" as it were.
     */
    // @PostConstruct
    public void init() {
        Animal seedCow = new Cow();
        seedCow.setName("George");
        seedCow.setBirthDate(new Date(System.currentTimeMillis()));

        animalRepository.save(seedCow);

        Animal seedGoat = new Goat();
        seedGoat.setName("Frank");
        seedGoat.setBirthDate(new Date(System.currentTimeMillis()));

        animalRepository.save(seedGoat);

        Animal seedMountainGoat = new MountainGoat();
        seedMountainGoat.setName("Billy");
        seedMountainGoat.setBirthDate(new Date(System.currentTimeMillis()));

        animalRepository.save(seedMountainGoat);

        Produce seedProduce = new Produce();
        seedProduce.setCount(5);
        seedProduce.setType("Milk");
        seedProduce.setAnimal(seedCow);

        produceRepository.save(seedProduce);
    }
}
