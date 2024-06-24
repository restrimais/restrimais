package com.lcdev.restrimais.repository;

import com.lcdev.restrimais.lib.entities.City;
import com.lcdev.restrimais.lib.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    City findByNameAndState(String name, State state);
}
