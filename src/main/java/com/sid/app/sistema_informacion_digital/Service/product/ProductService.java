package com.sid.app.sistema_informacion_digital.Service.product;

import com.sid.app.sistema_informacion_digital.Entity.Product;
import com.sid.app.sistema_informacion_digital.Entity.User;

import java.util.Optional;

public interface ProductService {
    public Optional<Product> findById(Long id);

    public Optional<Product> findByIdProduct(Long id);
}
