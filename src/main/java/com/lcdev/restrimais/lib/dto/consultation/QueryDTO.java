package com.lcdev.restrimais.lib.dto.consultation;

import com.lcdev.restrimais.lib.entities.Query;
import com.lcdev.restrimais.lib.enums.QueryStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryDTO {

    private Long id;
    private LocalDateTime queryDate;
    private QueryStatus status;
    private String observation;
    private Double price;
    private Long nutritionistId;
    private Long patientId;

    public QueryDTO(Query entity){
        id = entity.getId();
        queryDate = entity.getQueryDate();
        observation = entity.getObservation();
        price = entity.getPrice();
        nutritionistId = entity.getNutritionist().getId();
        patientId = entity.getPatient().getId();
    }

}
