package com.example.adminservice.entity;

import com.example.adminservice.entity.enums.OrderStatus;
import com.example.adminservice.entity.enums.OrderType;
import com.example.adminservice.entity.enums.PayType;
import com.example.adminservice.entity.templete.AbsEntity;
import com.example.adminservice.entity.templete.AbsNameEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ordes")
@Setter
@Getter
@ToString
@Where(clause = "deleted=false")
@SQLDelete(sql = "update order set deleted=true,status=false where id=?")
public class Order extends AbsEntity {
    //kimga tegishli ekani qo'shish kk
    @ManyToOne
    private User user;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToMany(mappedBy = "order")
    private List<Detail> detailList;

    //summa
    // Sale ni ham tekshirib kurish k.k
    private Double summa;
    @Enumerated(EnumType.STRING)
    private PayType payType;

    //olib ketish turi
    @Enumerated(EnumType.STRING)
    private OrderType orderType;

    @OneToOne
    private Address address;

}
