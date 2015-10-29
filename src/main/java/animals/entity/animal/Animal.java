package animals.entity.animal;

import animals.entity.Produce;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by Sam on 2015-10-27.
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

    @OneToMany
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Produce> getProduce() {
        return produce;
    }

    public void setProduce(List<Produce> produce) {
        this.produce = produce;
    }

    public void addProduce(Produce produce) {
        this.produce.add(produce);
    }
}
