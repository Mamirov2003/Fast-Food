package com.example.courierservice.entity;

import com.example.courierservice.entity.templete.AbsNameEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@ToString
@Where(clause = "deleted=false")
@SQLDelete(sql = "update detail set deleted=true,status=false where id=?")
public class Detail extends AbsNameEntity {
    @ManyToOne
    private User user;//kimga tegishli ekanligi
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Order order;
    @ManyToOne
    private Product product;
    @Column(nullable = false)
    private short quantity;
}
