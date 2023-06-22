package jpashop.domain;

import javax.persistence.Entity;

@Entity
public class Movie extends Item {

    private String director;
    private String actor;

    public Movie() {
    }

    public Movie(final String name,
                 final long price,
                 final int stockQuantity,
                 final String director,
                 final String actor) {
        super(null, name, price, stockQuantity);
        this.director = director;
        this.actor = actor;
    }

    public String getDirector() {
        return director;
    }

    public String getActor() {
        return actor;
    }
}
