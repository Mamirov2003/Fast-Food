package com.example.adminservice.entity.templete;

/**
 * @author "Husniddin Ulachov"
 * @created 11:40 AM on 8/3/2022
 * @project adminService
 */
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@Getter
@Setter
@ToString

public class AbsNameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean deleted = false;
    private boolean status = true;

    public AbsNameEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
