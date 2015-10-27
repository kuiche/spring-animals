package animals.entity;

import javax.persistence.*;

/**
 * Created by Sam on 2015-10-27.
 */
@Entity
public class Produce {
    @Id
    @GeneratedValue
    private Integer id;

    private String type;
    private Integer count;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn
    private Animal animal;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
