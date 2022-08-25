package com.example.adminservice.entity;

/**
 * @author "Husniddin Ulachov"
 * @created 11:47 AM on 8/3/2022
 * @project adminService
 */

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

    public Address(Long id, String nameUz, String nameRu, Double lat, Double lon, String target) {
        super(id, nameUz, nameRu);
        this.lat = lat;
        this.lon = lon;
        this.target = target;
    }
}
