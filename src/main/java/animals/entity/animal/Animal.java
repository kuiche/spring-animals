package animals.entity.animal;

import animals.entity.Produce;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by Sam on 2015-10-27.
 *
 * Basic abstract Animal class. Concrete classes to inherit this.
 * This class provides base fields for the different animals
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Animal {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable=false)
    private String name;

    @Column(name="date_birth")
    private Date birthDate;

    @Column(name="date_death")
    private Date deathDate;

    @OneToMany(mappedBy="animal", cascade=CascadeType.REMOVE)
    private List<Produce> produce;

    /**
     * Gets the noise made by the animal
     *
     * @return The noise
     */
    public abstract String getNoise();

    /**
     * Display name for the animal e.g. "Cow"
     *
     * @return The animal name
     */
    public abstract String getAnimalType();

    /**
     * Gets the animal's id
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the animal's id
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the animal's birthdate
     *
     * @return The animal's birth date
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the animal's birth date
     *
     * @param birthDate The animal's birth date
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Gets the animal's death date
     *
     * @return The animal's death date
     */
    public Date getDeathDate() {
        return deathDate;
    }

    /**
     * Sets the animal's death date
     *
     * @param deathDate The animal's death date
     */
    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    /**
     * Gets the animal's name
     *
     * @return The animal's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the animal's name
     *
     * @param name The animal's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the animal's produce
     *
     * @return A list of the animal's produce
     */
    public List<Produce> getProduce() {
        return produce;
    }

    /**
     * Sets the animal's produce
     *
     * @param produce A list of the animal's produce
     */
    public void setProduce(List<Produce> produce) {
        this.produce = produce;
    }

    /**
     * Adds a produce item to the animal's list of produce
     *
     * @param produce The produce item to add
     */
    public void addProduce(Produce produce) {
        this.produce.add(produce);
    }
}
