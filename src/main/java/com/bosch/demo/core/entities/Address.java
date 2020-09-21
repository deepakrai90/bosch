package com.bosch.demo.core.entities;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

/**
 * Created by Deepak Rai on 19/9/20.
 */
@Getter
@Builder
public class Address {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    @OneToOne
    private City city;

    @Column
    private String address;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="customer")
    private Customer customer;
}
