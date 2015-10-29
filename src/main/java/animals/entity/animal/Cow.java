package animals.entity.animal;

import javax.persistence.*;

/**
 * Created by Sam on 2015-10-27.
 */
@Entity
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
