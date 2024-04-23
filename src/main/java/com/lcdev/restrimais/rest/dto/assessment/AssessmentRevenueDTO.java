package com.lcdev.restrimais.rest.dto.assessment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssessmentRevenueDTO {

    private Long idRevenue;
    private Double score;
    private String comment;
    private String email;

}
