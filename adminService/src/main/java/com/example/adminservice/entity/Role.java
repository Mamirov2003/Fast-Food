package com.example.adminservice.entity;

import com.example.adminservice.entity.enums.Permission;
import com.example.adminservice.entity.templete.AbsNameEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import java.util.List;

/**
 * @author "Husniddin Ulachov"
 * @created 11:50 AM on 8/3/2022
 * @project adminService
 */
@Entity(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Where(clause = "deleted=false")
@SQLDelete(sql = "update role set deleted=true,status=false where id=?")
public class Role extends AbsNameEntity {
    @ElementCollection
    @Enumerated
    private List<Permission> permissionList;

//    public Role(Long id, String nameUz, String nameRu, boolean deleted, boolean status) {
//        super(id, nameUz, nameRu, deleted, status);
//    }

    public Role(Long id, String name) {
        super(id, name);
    }
}
