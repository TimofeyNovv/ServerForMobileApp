package com.example.mobileAppServer.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Setter
@Getter
@Table(name = "order_flower")
public class OrderEntity extends BaseEntity{

    @Column
    private String comment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    UserEntity userEntity;
}
