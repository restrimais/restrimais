package com.lcdev.restrimais.lib.entities;

import com.lcdev.restrimais.lib.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class User implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;
    private LocalDate birthDate;
    private String password;
    private String cpf;
    //    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String profileImg;
    private String phone;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new HashSet<>();
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public static User createUser(String email, boolean isPatient, boolean isNutritionist) {
        if (isPatient) {
            return new Patient();
        } else if (isNutritionist) {
            return new Nutritionist();
        } else {
            throw new IllegalArgumentException("Invalid user type");
        }
    }
}