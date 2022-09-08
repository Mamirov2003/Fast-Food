package com.example.operatorservice.entity;


import com.example.operatorservice.entity.templete.AbsNameEntity;
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
    @ManyToOne
    private Category parent;

    @ManyToMany
    private List<Filial> filial;


    public Category(Long id, String name, boolean deleted, boolean status, Category parent, List<Filial> filial) {
        super(id, name, deleted, status);
        this.parent = parent;
        this.filial = filial;
    }
}
