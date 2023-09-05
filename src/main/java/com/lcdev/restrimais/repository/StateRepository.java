package com.lcdev.restrimais.repository;

import com.lcdev.restrimais.domain.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

    @Query(value = "SELECT obj FROM State obj JOIN FETCH obj.cities WHERE obj IN :states")
    List<State> findStatesCities(List<State> states);

    State findByName(String name);
}
