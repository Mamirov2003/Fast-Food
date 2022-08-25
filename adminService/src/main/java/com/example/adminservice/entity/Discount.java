package com.example.adminservice.entity;

/**
 * @author "Husniddin Ulachov"
 * @created 11:47 AM on 8/3/2022
 * @project adminService
 */

import com.example.adminservice.entity.templete.AbsNameEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@ToString
@Where(clause = "deleted=false")
@SQLDelete(sql = "update discount set deleted=true,status=false where id=?")
public class Discount extends AbsNameEntity {
    private Double percentage;
    @JsonIgnore
    @OneToMany(mappedBy = "discount")
    private List<Product> product;

    public Discount(Long id, String nameUz, String nameRu, Double percentage, List<Product> product) {
        super(id, nameUz, nameRu);
        this.percentage = percentage;
        this.product = product;
    }
}