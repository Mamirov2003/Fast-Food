package com.example.adminservice.entity;

import com.example.adminservice.entity.templete.AbsNameEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.List;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;

/**
 * @author "Husniddin Ulachov"
 * @created 11:23 AM on 8/3/2022
 * @project adminService
 */
@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Where(clause = "deleted=false")
@SQLDelete(sql = "update users set deleted=true,status=false where id=?")
public class User extends AbsNameEntity implements UserDetails {


    @Column(unique = true)
    private String phone;
    private String password;
    private String fullName;
    private int reliabilty;//Ishonchliligi

    private Boolean online = null;
    @OneToMany
    private List<Address> addressList;
    @ManyToOne
    private Filial filial;
    private boolean enabled = true;
    private boolean accountExpired;
    private boolean accountLocked;
    private boolean credentialsExpired;
    @ManyToOne
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.role.getPermissionList().stream().map(permission -> new SimpleGrantedAuthority(permission.name())).collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return this.getPassword();
    }

    @Override
    public String getUsername() {
        return this.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.isCredentialsNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabled();
    }
}
