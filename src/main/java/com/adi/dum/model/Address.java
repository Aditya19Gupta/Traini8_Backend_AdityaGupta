package com.adi.dum.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Embeddable
@Getter
@Setter
@Entity
@Table(name = "address")
public class Address {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    Long id;
    @Column(name = "detailed_address")
    private String detailedAddress;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;

    @Column(name = "pincode", nullable = false, length = 6)
    private String pincode;
}
