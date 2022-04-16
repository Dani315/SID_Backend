package com.sid.app.sistema_informacion_digital.Controller;

import com.sid.app.sistema_informacion_digital.Entity.Product;
import com.sid.app.sistema_informacion_digital.Entity.User;
import com.sid.app.sistema_informacion_digital.Service.UserService;
import com.sid.app.sistema_informacion_digital.Service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> read(@PathVariable(value="id") Long userId){
        Optional<Product> optionalProduct = productService.findByIdProduct(userId);

        if(optionalProduct.isEmpty()) {
            return  ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(optionalProduct.get());
    }
}
