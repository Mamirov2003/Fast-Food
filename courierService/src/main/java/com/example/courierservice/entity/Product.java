package com.example.courierservice.entity;

import com.example.courierservice.entity.templete.AbsNameEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@ToString
@Where(clause = "deleted=false")
@SQLDelete(sql = "update product set deleted=true,status=false where id=?")
public class Product extends AbsNameEntity {
    @ManyToOne
    private Category category;
    @OneToOne
    private Attachment photo;
    private Double price;
    private String description;
    @ManyToOne
    private Discount discount;

    public Product(Long id, String name, boolean deleted, boolean status, Category category, Attachment photo, Double price, String description, Discount discount) {
        super(id, name, deleted, status);
        this.category = category;
        this.photo = photo;
        this.price = price;
        this.description = description;
        this.discount = discount;
    }
}
