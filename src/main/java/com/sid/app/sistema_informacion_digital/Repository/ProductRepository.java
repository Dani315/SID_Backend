package com.sid.app.sistema_informacion_digital.Repository;

import com.sid.app.sistema_informacion_digital.Entity.ColorReference;
import com.sid.app.sistema_informacion_digital.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository  extends JpaRepository<Product, String> {

    Optional<Product> findByEAN(String id);
    List<Product> findAllByOcassionTypeId(Long ocassionTypeId);
}
