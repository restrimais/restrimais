package com.lcdev.restrimais.projections;

public interface UserDetailsProjection {
    String getUsername();
    String getPassword();
    Long getRoleId();
    String getAuthority();
}
