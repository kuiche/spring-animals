package animals.entity.animal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Sam on 2015-10-28.
 */
@Entity
@DiscriminatorValue("MOUNTAIN_GOAT")
public class MountainGoat extends Goat {
    public String getAnimalType() {
        return "Mountain Goat";
    }
}
