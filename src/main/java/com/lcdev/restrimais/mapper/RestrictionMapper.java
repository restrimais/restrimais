package com.lcdev.restrimais.mapper;

import com.lcdev.restrimais.lib.entities.Restriction;
import com.lcdev.restrimais.lib.dto.restriction.RestrictionMinDTO;

public interface RestrictionMapper {

    Restriction mapRestriction(RestrictionMinDTO dto);
}
