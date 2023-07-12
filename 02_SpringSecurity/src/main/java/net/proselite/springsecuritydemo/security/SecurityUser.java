package net.proselite.springsecuritydemo.security;

import lombok.Data;
import net.proselite.springsecuritydemo.model.Permission;
import net.proselite.springsecuritydemo.model.Role;
import net.proselite.springsecuritydemo.model.Status;
import net.proselite.springsecuritydemo.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Data
public class SecurityUser implements UserDetails {

    private final String userName;
    private final String password;
    private final Set<SimpleGrantedAuthority> authorities;
    private final boolean isActive;

    public SecurityUser(String userName, String password, Set<SimpleGrantedAuthority> authorities, boolean isActive) {
        this.userName = userName;
        this.password = password;
        this.authorities = authorities;
        this.isActive = isActive;
    }

    public SecurityUser(User user) {
        this(user.getEmail(), user.getPassword(), user.getRole().getAutorities(), user.getStatus().equals(Status.ACTIVE));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }

//    public static UserDetails fromUser(User user) {
//        return new org.springframework.security.core.userdetails.User(
//                user.getEmail(), user.getPassword(),
//                user.getStatus().equals(Status.ACTIVE),
//                user.getStatus().equals(Status.ACTIVE),
//                user.getStatus().equals(Status.ACTIVE),
//                user.getStatus().equals(Status.ACTIVE),
//                user.getRole().getAutorities()
//        );
//    }

}
