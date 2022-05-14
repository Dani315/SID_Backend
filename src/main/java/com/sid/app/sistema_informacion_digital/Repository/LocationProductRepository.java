package com.sid.app.sistema_informacion_digital.Repository;

import com.sid.app.sistema_informacion_digital.Entity.LocationProduct;
import com.sid.app.sistema_informacion_digital.Entity.LocationProductPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationProductRepository    extends JpaRepository<LocationProduct, LocationProductPK> {
    List<LocationProduct> findAllByProductId(String ean);
}