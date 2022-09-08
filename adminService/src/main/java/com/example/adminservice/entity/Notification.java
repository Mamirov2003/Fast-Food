package com.example.adminservice.entity;

import com.example.adminservice.entity.templete.AbsNameEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.*;
import javax.persistence.Entity;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Where(clause = "deleted=false")
@SQLDelete(sql = "update notification set deleted=true,status=false where id=?")
public class Notification  extends AbsNameEntity {
    @JsonIgnore
    @ManyToOne
    private User user;
    private String title;
    private String body;
    @OneToOne
    private Attachment attachment; //attachment
    private boolean hasBot; //true
    private Timestamp sendTime;

    public Notification(Long id, String name, User user, String title, String body, Attachment attachment, boolean hasBot, Timestamp sendTime) {
        super(id, name);
        this.user = user;
        this.title = title;
        this.body = body;
        this.attachment = attachment;
        this.hasBot = hasBot;
        this.sendTime = sendTime;
    }
}
