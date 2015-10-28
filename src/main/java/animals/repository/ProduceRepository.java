package animals.repository;

import animals.entity.Produce;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Sam on 2015-10-27.
 */
public interface ProduceRepository extends JpaRepository<Produce, Integer> {
}
