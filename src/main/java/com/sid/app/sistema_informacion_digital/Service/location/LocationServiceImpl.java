package com.sid.app.sistema_informacion_digital.Service.location;

import com.sid.app.sistema_informacion_digital.Entity.Location;
import com.sid.app.sistema_informacion_digital.Entity.LocationProduct;
import com.sid.app.sistema_informacion_digital.Repository.LocationProductRepository;
import com.sid.app.sistema_informacion_digital.Repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationProductRepository locationProductRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Override
    @Transactional(readOnly = true)
    public List<LocationProduct> findLocationByProduct(String EAN) {
        return locationProductRepository.findAllByProductId(EAN);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Location> findLocation(Long serial) {
        return locationRepository.findBySerial(serial);
    }

}
