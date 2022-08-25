package com.example.kitchenservice.entity;
import com.example.kitchenservice.entity.enums.OrderStatus;
import com.example.kitchenservice.entity.enums.OrderType;
import com.example.kitchenservice.entity.enums.PayType;
import com.example.kitchenservice.entity.templete.AbsEntity;
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
    @ManyToOne
    private User user;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToMany(mappedBy = "order")
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
