package com.lcdev.restrimais.lib.dto.restriction;

import com.lcdev.restrimais.lib.entities.Category;
import com.lcdev.restrimais.lib.entities.Restriction;
import com.lcdev.restrimais.lib.dto.category.CategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestrictionMinDTO {

    private Long id;
    private String name;
    private List<CategoryDTO> categories = new ArrayList<>();
    public RestrictionMinDTO(Restriction entity){
        id = entity.getId();
        name = entity.getName();
        for (Category cat : entity.getCategories()){
            categories.add(new CategoryDTO(cat));
        }
    }

}
