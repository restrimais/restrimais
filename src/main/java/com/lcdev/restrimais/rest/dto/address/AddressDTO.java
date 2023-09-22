package com.lcdev.restrimais.rest.dto.address;

import com.lcdev.restrimais.domain.entities.Address;
import com.lcdev.restrimais.rest.dto.city.CityStateDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private Long id;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String cep;
    private CityStateDTO city;
//    private Long patientId;
//    private Long nutritionistId;

    public AddressDTO(Address entity){
        id = entity.getId();
        street = entity.getStreet();
        number = entity.getNumber();
        complement = entity.getComplement();
        neighborhood = entity.getNeighborhood();
        cep = entity.getCep();
        city = new CityStateDTO(entity.getCity());
//        patientId = entity.getPatient().getId();
//        nutritionistId = entity.getNutritionist().getId();
    }
}
