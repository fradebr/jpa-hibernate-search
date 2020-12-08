package eu.fade.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

    @Column(name = "empl_street", columnDefinition = "VARCHAR(80)")
    private String street;
    @Column(name = "empl_house_number", columnDefinition = "VARCHAR(10)")
    private String number;

    @Column(name = "empl_postal_code", columnDefinition = "VARCHAR(20)")
    private String zip;

    @Column(name = "empl_place", columnDefinition = "VARCHAR(50)")
    private String city;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
