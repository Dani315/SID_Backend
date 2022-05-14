package com.sid.app.sistema_informacion_digital.Service.product;

import com.sid.app.sistema_informacion_digital.Entity.Color;
import com.sid.app.sistema_informacion_digital.Entity.Product;
import com.sid.app.sistema_informacion_digital.Entity.Reference;
import com.sid.app.sistema_informacion_digital.Entity.Size;
import com.sid.app.sistema_informacion_digital.Repository.ColorRepository;
import com.sid.app.sistema_informacion_digital.Repository.ProductRepository;
import com.sid.app.sistema_informacion_digital.Repository.ReferenceRepository;
import com.sid.app.sistema_informacion_digital.Repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ColorRepository colorRepository;

    @Autowired
    private SizeRepository sizeRepository;

    @Autowired
    private ReferenceRepository referenceRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findByEAN(String id) {
        return productRepository.findByEAN(id);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<Color> findColor(Long code) {
        return colorRepository.findByCode(code);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Size> findSize(Long code) {
        return sizeRepository.findByCode(code);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Reference> findReference(Long code) {
        return referenceRepository.findByCode(code);
    }
}
