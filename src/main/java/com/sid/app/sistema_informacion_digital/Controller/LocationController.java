package com.sid.app.sistema_informacion_digital.Controller;

import com.sid.app.sistema_informacion_digital.Controller.dto.LocationDto;
import com.sid.app.sistema_informacion_digital.Controller.dto.ResponseDto;
import com.sid.app.sistema_informacion_digital.UseCase.LocationUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/location")
public class LocationController {

    @Autowired
    LocationUseCase locationUseCase;

    @GetMapping("/{ean}")
    public ResponseEntity<?> read(@PathVariable(value="ean") String ean){

        return ResponseEntity.ok(ResponseDto.builder()
                .info(locationUseCase.findAllLocationByProduct(ean)
                        .stream()
                        .map(locationProduct -> locationUseCase.findLocation(locationProduct.getLocationId())
                                .map(location -> LocationDto.builder()
                                        .serial(locationProduct.getLocationId())
                                        .address(location.getAddress())
                                        .name(location.getName())
                                        .latitude(location.getLatitude())
                                        .longitude(location.getLongitude())
                                        .stock(locationProduct.getStock())
                                        .build()))
                        .collect(Collectors.toList()))
                .build()
        );

    }

}
