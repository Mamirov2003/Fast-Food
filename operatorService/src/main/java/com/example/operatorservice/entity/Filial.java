package com.example.operatorservice.entity;

import com.example.operatorservice.entity.templete.AbsNameEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
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

}
