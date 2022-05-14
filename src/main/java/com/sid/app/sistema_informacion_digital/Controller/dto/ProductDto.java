package com.sid.app.sistema_informacion_digital.Controller.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductDto {

    private String ean;

    private ColorDto color;

    private SizeDto size;

    private Long codeReference;

    private String nameReference;

    private Double price;

    private Long ocassionTypeId;

    private Long qualificationId;
}
