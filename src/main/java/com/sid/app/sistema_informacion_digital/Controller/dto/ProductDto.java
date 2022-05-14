package com.sid.app.sistema_informacion_digital.Controller.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductDto {

    private String ean;

    private DetalleDto color;

    private DetalleDto size;

    private Long codeReference;

    private String nameReference;

    private Double price;
}
