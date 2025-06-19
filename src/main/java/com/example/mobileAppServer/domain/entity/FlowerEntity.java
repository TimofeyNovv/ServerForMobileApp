package com.example.mobileAppServer.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "flowers")
public class FlowerEntity extends BaseEntity{

    @Column
    private String image;

    @Column
    private String name;

    @Column
    private Double price;

    @Column
    private Double rating;
}
