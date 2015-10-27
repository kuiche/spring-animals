package animals.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by Sam on 2015-10-27.
 */
@Entity
public class Animal {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @Column(name="date_birth")
    private Date birthDate;

    @Column(name="date_death")
    private Date deathDate;

    @Column(name="type")
    private String animalType;

    @OneToMany
    private List<Produce> produce;

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

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public List<Produce> getProduce() {
        return produce;
    }

    public void setProduce(List<Produce> produce) {
        this.produce = produce;
    }
}
