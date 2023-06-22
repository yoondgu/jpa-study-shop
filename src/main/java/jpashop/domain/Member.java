package jpashop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Member extends BaseEntity {

    @Column(name = "MEMBER_ID")
    @Id @GeneratedValue
    private Long id;

    private String name;
    private String city;
    private String street;
    private String zipcode;

    public Member() {
    }

    public Member(final Long id,
                  final String name,
                  final String city,
                  final String street,
                  final String zipcode) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
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
}
