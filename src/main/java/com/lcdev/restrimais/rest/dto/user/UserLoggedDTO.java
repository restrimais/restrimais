package com.lcdev.restrimais.rest.dto.user;

import com.lcdev.restrimais.domain.entities.User;
import com.lcdev.restrimais.domain.enums.Gender;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserLoggedDTO {

    private Long id;

    private String name;

    private String email;
    private LocalDate birthDate;
    private String cpf;
    private Gender gender;
    private String profileImg;
    private String phone;

    private List<String> roles = new ArrayList<>();

    public UserLoggedDTO(User entity) {
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
        birthDate = entity.getBirthDate();
        cpf = entity.getCpf();
        gender = entity.getGender();
        profileImg = entity.getProfileImg();
        phone = entity.getPhone();
       for (GrantedAuthority authority : entity.getAuthorities()){
           roles.add(authority.getAuthority());
       }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
