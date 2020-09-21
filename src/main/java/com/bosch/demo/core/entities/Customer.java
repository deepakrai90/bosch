package com.bosch.demo.core.entities;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Deepak Rai on 19/9/20.
 */
@Getter
@Builder
@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @OneToMany(fetch=FetchType.LAZY, mappedBy = "customer_id")
    private List<Address> address;

}
