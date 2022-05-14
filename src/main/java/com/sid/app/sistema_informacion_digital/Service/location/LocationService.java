package com.sid.app.sistema_informacion_digital.Service.location;

import com.sid.app.sistema_informacion_digital.Entity.Location;
import com.sid.app.sistema_informacion_digital.Entity.LocationProduct;

import java.util.List;
import java.util.Optional;

public interface LocationService {
    List<LocationProduct> findLocationByProduct(String EAN);

    Optional<Location> findLocation(Long serial);
}
