package com.bosch.demo.core.entities;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * Created by Deepak Rai on 19/9/20.
 */
@Getter
@Builder
@Entity
@Table
public class City {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;
}
