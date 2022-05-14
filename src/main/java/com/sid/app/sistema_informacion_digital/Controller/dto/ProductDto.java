package com.sid.app.sistema_informacion_digital.Controller.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductDto {

    private String ean;

    private String colorName;

    private Long colorCode;

    private String sizeName;

    private Long sizeCode;

    private Long codeReference;

    private String nameReference;

    private Double price;
}
