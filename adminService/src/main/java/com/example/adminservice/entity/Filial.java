package com.example.adminservice.entity;

import com.example.adminservice.entity.templete.AbsNameEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author "Husniddin Ulachov"
 * @created 11:48 AM on 8/3/2022
 * @project adminService
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@ToString
@Where(clause = "delete = false")
@SQLDelete(sql = "update filial set deleted = true,status = false where id=?")
public class Filial extends AbsNameEntity {

    @Temporal(TemporalType.TIME)
    private Date startTime;

    @Temporal(TemporalType.TIME)
    private Date endTime;

    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "filial")
    private List<User> user;

    public Filial(Long id, String nameUz, String nameRu, Date startTime, Date endTime, Address address) {
        super(id, nameUz, nameRu);
        this.startTime = startTime;
        this.endTime = endTime;
        this.address = address;
    }
}
