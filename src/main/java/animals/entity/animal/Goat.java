package animals.entity.animal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Sam on 2015-10-27.
 */
@Entity
@DiscriminatorValue("GOAT")
public class Goat extends Animal {
    /**
     * Goats go "BEHHH"
     */
    protected String noise = "BEHHH";

    @Override
    public String getNoise() {
        return noise;
    }

    @Override
    public String getAnimalType() {
        return "Goat";
    }
}
