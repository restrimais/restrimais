package com.lcdev.restrimais.service.impl;

import com.lcdev.restrimais.lib.entities.Nutritionist;
import com.lcdev.restrimais.lib.entities.Patient;
import com.lcdev.restrimais.lib.entities.Role;
import com.lcdev.restrimais.lib.entities.User;
import com.lcdev.restrimais.projections.UserDetailsProjection;
import com.lcdev.restrimais.repository.NutritionistRepository;
import com.lcdev.restrimais.repository.PatientRepository;
import com.lcdev.restrimais.repository.UserRepository;
import com.lcdev.restrimais.lib.dto.user.UserLoggedDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService {

    private final UserRepository repository;
    private final PatientRepository patientRepository;
    private final NutritionistRepository nutritionistRepository;

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
            user.setEmail(username);
            setRoles(user, patientResult);
        } else {
            user = new Nutritionist();
            user.setEmail(username);
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

    protected User authenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new UsernameNotFoundException("No authenticated user found");
        }

        Jwt jwtPrincipal = (Jwt) authentication.getPrincipal();
        String username = jwtPrincipal.getClaim("username");

        return findUserByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Email not found"));
    }

    private Optional<User> findUserByEmail(String email) {
        return patientRepository.findByEmail(email)
                .map(User.class::cast)
                .or(() -> nutritionistRepository.findByEmail(email).map(User.class::cast));
    }

    @Transactional(readOnly = true)
    public UserLoggedDTO getMe(){
        User user = authenticated();
        return new UserLoggedDTO(user);
    }
}
