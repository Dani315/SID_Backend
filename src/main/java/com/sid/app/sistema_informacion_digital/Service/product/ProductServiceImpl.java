package com.sid.app.sistema_informacion_digital.Service.product;

import com.sid.app.sistema_informacion_digital.Entity.Product;
import com.sid.app.sistema_informacion_digital.Entity.User;
import com.sid.app.sistema_informacion_digital.Repository.ProductRepository;
import com.sid.app.sistema_informacion_digital.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;


    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Optional<Product> findByIdProduct(Long id) {
        return productRepository.findByIdProduct(id);
    }

}
