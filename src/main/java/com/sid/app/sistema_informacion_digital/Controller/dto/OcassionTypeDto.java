package com.sid.app.sistema_informacion_digital.Controller.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OcassionTypeDto {

    private ProductDto product;

    private String image;
}
