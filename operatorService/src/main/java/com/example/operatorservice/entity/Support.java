package com.example.operatorservice.entity;
import com.example.operatorservice.entity.enums.SupportType;
import com.example.operatorservice.entity.templete.AbsNameEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@ToString
@Where(clause = "deleted=false")
@SQLDelete(sql = "update support set deleted=true,status=false where id=?")
public class Support extends AbsNameEntity {
    @Enumerated(EnumType.STRING)
    private SupportType supportType;

    @ElementCollection
    private Set<String> phoneList;

    private String title;
    private String description;
    private String photo;
}
