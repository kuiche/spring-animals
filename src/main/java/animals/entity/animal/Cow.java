package animals.entity.animal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Sam on 2015-10-27.
 */
@Entity
@DiscriminatorValue("COW")
public class Cow extends Animal {
    /**
     * Cows go "Moo"
     */
    protected String noise = "Moo";

    @Override
    public String getNoise() {
        return noise;
    }

    @Override
    public String getAnimalType() {
        return "Cow";
    }
}
