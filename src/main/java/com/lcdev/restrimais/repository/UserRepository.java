package com.lcdev.restrimais.repository;

import com.lcdev.restrimais.lib.entities.User;
import com.lcdev.restrimais.projections.UserDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(nativeQuery = true, value = """
        SELECT tb_patient.email AS username, tb_patient.password, tb_role.id AS roleId, tb_role.authority
        FROM tb_patient
        INNER JOIN tb_patient_role ON tb_patient.id = tb_patient_role.patient_id
        INNER JOIN tb_role ON tb_role.id = tb_patient_role.role_id
        WHERE tb_patient.email = :email
    """)
	List<UserDetailsProjection> searchPatientAndRolesByEmail(String email);

	@Query(nativeQuery = true, value = """
        SELECT tb_nutritionist.email AS username, tb_nutritionist.password, tb_role.id AS roleId, tb_role.authority
        FROM tb_nutritionist
        INNER JOIN tb_nutritionist_role ON tb_nutritionist.id = tb_nutritionist_role.nutritionist_id
        INNER JOIN tb_role ON tb_role.id = tb_nutritionist_role.role_id
        WHERE tb_nutritionist.email = :email
    """)
	List<UserDetailsProjection> searchNutritionistAndRolesByEmail(String email);

}
