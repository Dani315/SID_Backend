package com.sid.app.sistema_informacion_digital.Service.product;

import com.sid.app.sistema_informacion_digital.Entity.Color;
import com.sid.app.sistema_informacion_digital.Entity.Product;
import com.sid.app.sistema_informacion_digital.Entity.Reference;
import com.sid.app.sistema_informacion_digital.Entity.Size;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ProductService {
    Optional<Product> findByEAN(String id);

    Optional<Color> findColor(Long code);

    Optional<Size> findSize(Long code);

    Optional<Reference> findReference(Long code);
}
