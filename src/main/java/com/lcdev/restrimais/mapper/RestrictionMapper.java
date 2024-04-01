package com.lcdev.restrimais.mapper;

import com.lcdev.restrimais.domain.entities.Restriction;
import com.lcdev.restrimais.rest.dto.restriction.RestrictionMinDTO;

public interface RestrictionMapper {

    Restriction mapRestriction(RestrictionMinDTO dto);
}
