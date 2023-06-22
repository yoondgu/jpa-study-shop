package jpashop.domain;

import javax.persistence.Entity;

@Entity
public class Album extends Item {

    private String artist;
    private String etc;

    public Album() {
    }

    public Album(final String name,
                 final long price,
                 final int stockQuantity,
                 final String artist,
                 final String etc) {
        super(null, name, price, stockQuantity);
        this.artist = artist;
        this.etc = etc;
    }

    public String getArtist() {
        return artist;
    }

    public String getEtc() {
        return etc;
    }
}
