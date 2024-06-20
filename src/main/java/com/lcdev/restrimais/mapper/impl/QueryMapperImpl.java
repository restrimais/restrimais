package com.lcdev.restrimais.mapper.impl;

import com.lcdev.restrimais.domain.entities.Nutritionist;
import com.lcdev.restrimais.domain.entities.Patient;
import com.lcdev.restrimais.domain.entities.Query;
import com.lcdev.restrimais.domain.enums.QueryStatus;
import com.lcdev.restrimais.mapper.QueryMapper;
import com.lcdev.restrimais.rest.dto.consultation.QueryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QueryMapperImpl implements QueryMapper {
    @Override
    public Query mapQuery(QueryDTO dto, Patient patient, Nutritionist nutritionist) {


        Query entity = new Query();
        entity.setPatient(patient);
        entity.setNutritionist(nutritionist);
        entity.setQueryDate(dto.getQueryDate());
        entity.setStatus(QueryStatus.BOOKED);
        entity.setObservation(dto.getObservation());
        entity.setPrice(dto.getPrice());

        return entity;
    }

}
