package com.sid.app.sistema_informacion_digital.Controller.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ImageDto {
    private Long code;
    private String productId;
    private String url;
}
