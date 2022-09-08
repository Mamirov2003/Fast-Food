package com.example.adminservice.entity;

import com.example.adminservice.entity.templete.AbsNameEntity;
import lombok.*;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@ToString
public class Address extends AbsNameEntity {
    private Double lat;
    private Double lon;
    private String target;

    public Address(Long id, String name, Double lat, Double lon, String target) {
        super(id, name);
        this.lat = lat;
        this.lon = lon;
        this.target = target;
    }
}
