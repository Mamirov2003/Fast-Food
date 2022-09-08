package com.example.adminservice.entity;

import com.example.adminservice.entity.templete.AbsNameEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@ToString
@Where(clause = "deleted=false")
@SQLDelete(sql = "update category set deleted=true,status=false where id=?")
public class Category extends AbsNameEntity {
    @JsonIgnore
    @ManyToOne
    private Category parent;

    @JsonIgnore
    @ManyToMany
    private List<Filial> filial;

    public Category(Long id, String name) {
        super(id, name);
    }
}
