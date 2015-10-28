package animals.service;

import animals.entity.animal.Animal;
import animals.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sam on 2015-10-28.
 */
@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> findAll() {
        return animalRepository.findAll();
    }
}
