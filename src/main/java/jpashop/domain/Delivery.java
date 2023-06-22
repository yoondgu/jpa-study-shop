package jpashop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Delivery extends BaseEntity {

    @Column(name = "DELIVERY_ID")
    @Id @GeneratedValue
    private Long id;
    private String city;
    private String street;
    private String zipcode;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    public Delivery() {
    }

    public Delivery(final Long id,
                    final String city,
                    final String street,
                    final String zipcode,
                    final DeliveryStatus status) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public DeliveryStatus getStatus() {
        return status;
    }
}
