package com.sid.app.sistema_informacion_digital.Controller.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class QualificationDto {
    private ProductDto product;
    private int quantityLike;
    private int quantityDisLike;
}
