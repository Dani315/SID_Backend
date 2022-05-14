package com.sid.app.sistema_informacion_digital.UseCase;

import com.sid.app.sistema_informacion_digital.Entity.Image;
import com.sid.app.sistema_informacion_digital.Entity.Location;
import com.sid.app.sistema_informacion_digital.Entity.LocationProduct;
import com.sid.app.sistema_informacion_digital.Service.location.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LocationUseCase {

    @Autowired
    LocationService locationService;

    public Optional<Location> findLocation(Long serial) {
        return locationService.findLocation(serial);
    }

    public List<LocationProduct> findAllLocationByProduct(String EAN) {
        return  locationService.findLocationByProduct(EAN);
    }
}
