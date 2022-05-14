package com.sid.app.sistema_informacion_digital.Service.product;

import com.sid.app.sistema_informacion_digital.Entity.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<Product> findByEAN(String EAN);

    Optional<Color> findColor(Long code);

    Optional<Size> findSize(Long code);

    Optional<Reference> findReference(Long code);

    List<Image> findAllImages(String EAN);

    List<Size> findAllSizeReference(Long code);

    List<Color> findAllColorReference(Long code);

    @Transactional(readOnly = true)
    List<Product> findByOcassionType(Long ocassionTypeId);
}
