package com.lcdev.restrimais.mapper;

import com.lcdev.restrimais.lib.entities.Nutritionist;
import com.lcdev.restrimais.lib.entities.Patient;
import com.lcdev.restrimais.lib.entities.Query;
import com.lcdev.restrimais.lib.dto.consultation.QueryDTO;

public interface QueryMapper {

    Query mapQuery(QueryDTO dto, Patient patient, Nutritionist nutritionist);

}
