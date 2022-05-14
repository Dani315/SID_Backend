package com.sid.app.sistema_informacion_digital.UseCase;

import com.sid.app.sistema_informacion_digital.Entity.Color;
import com.sid.app.sistema_informacion_digital.Entity.Product;
import com.sid.app.sistema_informacion_digital.Entity.Reference;
import com.sid.app.sistema_informacion_digital.Entity.Size;
import com.sid.app.sistema_informacion_digital.Service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductUseCase {

    @Autowired
    private ProductService productService;

    public Optional<Product> findProduct(String EAN) {
       return productService.findByEAN(EAN);
    }

    public Optional<Reference> findReference(Long code) {
        return productService.findReference(code);
    }


    public Optional<Color> findColor(Long code) {
        return productService.findColor(code);
    }

    public Optional<Size> findSize(Long code) {
        return productService.findSize(code);
    }
}
