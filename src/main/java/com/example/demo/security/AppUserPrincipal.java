package com.example.demo.security;

import com.example.demo.peristance.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

@AllArgsConstructor
public class AppUserPrincipal implements UserDetails {

    private final UserEntity userEntity;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userEntity.getRoles()
                .stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return userEntity.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO should come from db
        //  return userEntity.getStatus() != UserStatus.CREDENTIALS_EXPIRED;
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO should come from db
        //    return userEntity.getStatus() != UserStatus.LOCKED;
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO should come from db
        //    UserStatus.CREDENTIALS_EXPIRED != userEntity.getStatus();
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO should come from db
        //    UserStatus.ACTIVE == userEntity.getStatus();
        return true;
    }
}
