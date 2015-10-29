package animals.repository;

import animals.entity.Produce;
import animals.entity.animal.Animal;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Sam on 2015-10-27.
 */
public interface ProduceRepository extends JpaRepository<Produce, Integer> {
    /**
     * Find by animal
     *
     * @param animal the Animal
     * @return list of produce
     */
    List<Produce> findByAnimal(Animal animal);

    /**
     * Find by animal with Pageable
     *
     * @param animal the Animal
     * @param pageable the Pageable
     * @return list of produce
     */
    List<Produce> findByAnimal(Animal animal, Pageable pageable);
}
