package com.lcdev.restrimais.mapper;

import com.lcdev.restrimais.domain.entities.Nutritionist;
import com.lcdev.restrimais.domain.entities.Patient;
import com.lcdev.restrimais.domain.entities.Query;
import com.lcdev.restrimais.rest.dto.consultation.QueryDTO;

public interface QueryMapper {

    Query mapQuery(QueryDTO dto, Patient patient, Nutritionist nutritionist);

}
