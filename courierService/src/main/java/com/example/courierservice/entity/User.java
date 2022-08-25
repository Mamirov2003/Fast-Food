package com.example.courierservice.entity;

import com.example.courierservice.entity.templete.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Where(clause = "deleted=false")
@SQLDelete(sql = "update users set deleted=true,status=false where id=?")
public class User extends AbsEntity implements UserDetails {

    private String phone;
    private String password;
    private String fullName;
    private int reliability;//Ishonchliligi
    private Boolean online = null;

    private String region;
    @OneToMany(mappedBy = "user")
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

    public User(Long Id, boolean deleted, boolean status, Long createdBy, Long updatedBy, String phone, String password, String fullName, int reliability, Boolean online, List<Address> addressList, Filial filial, boolean enabled, boolean accountExpired, boolean accountLocked, boolean credentialsExpired, Role role) {
        super(Id,deleted, status, createdBy, updatedBy);
        this.phone = phone;
        this.password = password;
        this.fullName = fullName;
        this.reliability = reliability;
        this.online = online;
        this.addressList = addressList;
        this.filial = filial;
        this.enabled = enabled;
        this.accountExpired = accountExpired;
        this.accountLocked = accountLocked;
        this.credentialsExpired = credentialsExpired;
        this.role = role;
    }
}
