package com.sid.app.sistema_informacion_digital.Controller.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LocationDto {

    private Long serial;

    private String address;

    private String name;

    private Double latitude;

    private Double longitude;

    private Integer stock;

}
