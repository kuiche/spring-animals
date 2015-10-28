package animals.repository;

import animals.entity.animal.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Sam on 2015-10-27.
 */
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
}
