package com.lcdev.restrimais.lib.dto.revenue;

import com.lcdev.restrimais.lib.dto.assessment.RevenueUserCommentDTO;
import com.lcdev.restrimais.lib.dto.ingredients.IngredientsDTO;
import com.lcdev.restrimais.lib.dto.preparetion.PreparetionDTO;
import com.lcdev.restrimais.lib.entities.Category;
import com.lcdev.restrimais.lib.entities.Revenue;
import com.lcdev.restrimais.lib.dto.category.CategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RevenueDTO {

    private Long id;
    private String title;
    private String img;
    private String description;
    private Double score;
    private Integer count;
    private PreparetionDTO preparetion;
    private List<IngredientsDTO> ingredients = new ArrayList<>();
    private List<CategoryDTO> categories = new ArrayList<>();
    private List<RevenueUserCommentDTO> comments = new ArrayList<>();

    public RevenueDTO(Revenue entity){
        id = entity.getId();
        title = entity.getTitle();
        img = entity.getImg();
        description = entity.getDescription();
        preparetion = new PreparetionDTO(entity.getPreparation());
        score = entity.getScore();
        count = entity.getCount();
        ingredients = entity.getIngredients().stream().map(IngredientsDTO::new).collect(Collectors.toList());
        comments = entity.getAssessments().stream().map(RevenueUserCommentDTO::new).collect(Collectors.toList());
        for (Category cat : entity.getCategories()){
            categories.add(new CategoryDTO(cat));
        }
    }

}
