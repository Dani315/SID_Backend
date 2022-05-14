package com.sid.app.sistema_informacion_digital.Service.product;

import com.sid.app.sistema_informacion_digital.Entity.*;
import com.sid.app.sistema_informacion_digital.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    @Autowired
    private ImageRepository imageRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findByEAN(String EAN) {
        return productRepository.findByEAN(EAN);
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

    @Override
    @Transactional(readOnly = true)
    public List<Image> findAllImages(String EAN) {
        return imageRepository.findAllByProductId(EAN);
    }
}
