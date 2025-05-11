package br.com.zeguitech.apis.addresses.model;

import javax.persistence.*;
import br.com.zeguitech.apis.users.model.User;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String zipcode;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

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

public String getComplement() {
    return complement;
}

public void setComplement(String complement) {
    this.complement = complement;
}

public String getNeighborhood() {
    return neighborhood;
}

public void setNeighborhood(String neighborhood) {
    this.neighborhood = neighborhood;
}

public String getCity() {
    return city;
}

public void setCity(String city) {
    this.city = city;
}

public String getState() {
    return state;
}

public void setState(String state) {
    this.state = state;
}

public String getZipcode() {
    return zipcode;
}

public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
}
}
