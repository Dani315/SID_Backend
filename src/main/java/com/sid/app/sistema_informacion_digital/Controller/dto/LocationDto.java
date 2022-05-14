package com.sid.app.sistema_informacion_digital.Controller.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class LocationDto {

    private Long serial;

    private String address;

    private String name;

    private List<Double> geography;

    private Integer stock;

}
