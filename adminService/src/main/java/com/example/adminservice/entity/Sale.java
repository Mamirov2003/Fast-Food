package com.example.adminservice.entity;

/**
 * @author "Husniddin Ulachov"
 * @created 11:47 AM on 8/3/2022
 * @project adminService
 */

import com.example.adminservice.entity.templete.AbsNameEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@ToString
@Where(clause = "deleted=false")
@SQLDelete(sql = "update sale set deleted=true,status=false where id=?")
public class Sale extends AbsNameEntity {
    private Timestamp start;
    private Timestamp end;
    private Double summa;
    private Double foiz;

    public Sale(Long id, String nameUz, String nameRu, Timestamp start, Timestamp end, Double summa, Double foiz) {
        super(id, nameUz, nameRu);
        this.start = start;
        this.end = end;
        this.summa = summa;
        this.foiz = foiz;
    }
}