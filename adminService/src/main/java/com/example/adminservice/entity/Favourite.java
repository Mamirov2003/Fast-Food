package com.example.adminservice.entity;

import com.example.adminservice.entity.templete.AbsEntity;
import lombok.*;

import javax.persistence.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Favourite extends AbsEntity {
    @OneToOne
    private User user;
    @OneToMany
    private List<Product> productList;
}
