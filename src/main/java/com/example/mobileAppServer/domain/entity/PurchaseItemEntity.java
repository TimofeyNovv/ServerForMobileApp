package com.example.mobileAppServer.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "purchase_item")
public class PurchaseItemEntity extends BaseEntity{

    @Column
    private Integer count;

    @ManyToOne
    @JoinColumn(name = "flower_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private FlowerEntity flowerEntity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private OrderEntity orderEntity;
}
