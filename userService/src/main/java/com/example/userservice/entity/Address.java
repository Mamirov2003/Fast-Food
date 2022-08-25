package com.example.userservice.entity;

import com.example.userservice.entity.templete.AbsNameEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@ToString
public class Address extends AbsNameEntity {
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private User user;
    private Double lat;
    private Double lon;
    private String target;
}
