package com.lcdev.restrimais.lib.dto.revenue;

import com.lcdev.restrimais.lib.entities.Revenue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RevenueMinDTO {

    private Long id;
    private String title;
    private String img;
    private String description;

    public RevenueMinDTO(Revenue entity){
        id = entity.getId();
        title = entity.getTitle();
        img = entity.getImg();
        description = entity.getDescription();
    }

}
