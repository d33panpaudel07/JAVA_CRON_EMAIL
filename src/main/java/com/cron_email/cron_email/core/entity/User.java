package com.cron_email.cron_email.core.entity;

import com.cron_email.cron_email.features.base.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USERS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity<Long> {
    @Column(name = "USERNAME")
    private String username;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "IS_ACCOUNT_EXPIRED")
    private Character isAccountExpired;

    @Column(name = "IS_CREDENTIAL_EXPIRED")
    private Character isCredentialExpired;

    @Column(name = "IS_LOCKED")
    private Character isLocked;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "USER_ROLES",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID")
    )
    @JsonManagedReference
    private Set<Role> roles = new HashSet<>();


}

