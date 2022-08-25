package com.example.userservice.entity;
import com.example.userservice.entity.enums.OrderStatus;
import com.example.userservice.entity.enums.OrderType;
import com.example.userservice.entity.enums.PayType;
import com.example.userservice.entity.templete.AbsEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "orders")
@Setter
@Getter
@ToString
@Where(clause = "deleted=false")
@SQLDelete(sql = "update orders set deleted=true,status=false where id=?")
public class Order extends AbsEntity {
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "user_id",insertable = false,updatable = false)
    private User user;

    @Column(name = "user_id")
    private Long userId;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToMany
    private List<Detail> detailList;

    private Double summa;

    @Enumerated(EnumType.STRING)
    private PayType payType;

    @Enumerated(EnumType.STRING)
    private OrderType orderType;

    @OneToOne
    private Address address;

    @ManyToOne
    private Filial filial;
}
