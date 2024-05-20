package com.lcdev.restrimais.service.impl;

import com.lcdev.restrimais.domain.entities.Nutritionist;
import com.lcdev.restrimais.domain.entities.Patient;
import com.lcdev.restrimais.domain.entities.Role;
import com.lcdev.restrimais.domain.entities.User;
import com.lcdev.restrimais.projections.UserDetailsProjection;
import com.lcdev.restrimais.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<UserDetailsProjection> patientResult = repository.searchPatientAndRolesByEmail(username);
        List<UserDetailsProjection> nutritionistResult = repository.searchNutritionistAndRolesByEmail(username);

        if (patientResult.isEmpty() && nutritionistResult.isEmpty()) {
            throw new UsernameNotFoundException("User not found!");
        }

        User user;
        if (!patientResult.isEmpty()) {
            user = new Patient();
            setRoles(user, patientResult);
        } else {
            user = new Nutritionist();
            setRoles(user, nutritionistResult);
        }

        return user;
    }

    private void setRoles(User user, List<UserDetailsProjection> result) {
        user.setPassword(result.get(0).getPassword());
        for (UserDetailsProjection projection : result) {
            if (user instanceof Patient) {
                ((Patient) user).addRole(new Role(projection.getRoleId(), projection.getAuthority()));
            } else if (user instanceof Nutritionist) {
                ((Nutritionist) user).addRole(new Role(projection.getRoleId(), projection.getAuthority()));
            }
        }
    }
}
