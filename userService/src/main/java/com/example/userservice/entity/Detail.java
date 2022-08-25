package com.example.userservice.entity;

import com.example.userservice.entity.templete.AbsNameEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

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

    @ManyToOne(cascade = CascadeType.ALL)
    private Order orders;

    @ManyToOne
    private Product product;
    @Column(nullable = false)
    private short quantity;
}
