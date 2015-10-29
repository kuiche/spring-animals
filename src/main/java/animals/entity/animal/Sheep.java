package animals.entity.animal;

import javax.persistence.Entity;

/**
 * Created by Sam on 2015-10-28.
 */
@Entity
public class Sheep extends Animal {
    /**
     * Sheep go "Baaaa"
     */
    protected String noise = "Baaaa";

    @Override
    public String getNoise() {
        return noise;
    }

    @Override
    public String getAnimalType() {
        return "Sheep";
    }
}
