package com.sid.app.sistema_informacion_digital.UseCase;

import com.sid.app.sistema_informacion_digital.Entity.*;
import com.sid.app.sistema_informacion_digital.Entity.Enumerable.StateGift;
import com.sid.app.sistema_informacion_digital.Service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class ProductUseCase {

    @Autowired
    private ProductService productService;

    public Optional<Product> findProduct(String EAN) {
       return productService.findByEAN(EAN);
    }

    public List<Product> findAllProducts() {
        return productService.findAll();
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

    public List<Image> findAllImagesByProduct(String EAN) {
        return  productService.findAllImages(EAN);
    }

    public List<Size> findAllSizeReferenceByProduct(Long code) {
        return  productService.findAllSizeReference(code);
    }

    public List<Color> findAllColorReferenceByProduct(Long code) {
        return  productService.findAllColorReference(code);
    }

    public List<Product> findAllByOcassionType(Long ocassionTypeId) {
        return  productService.findByOcassionType(ocassionTypeId);
    }

    public Optional<Qualification> findByQualification(Long qualificationId) {
        return  productService.findByQualification(qualificationId);
    }

    public Optional<Qualification> updateLikes(Long idQuialification, int type){
        Optional<Qualification> qualification = productService.findByQualification(idQuialification);

        if (qualification.isPresent()) {
            if (type==0) {
                qualification.get().setQuantityLike(qualification.get().getQuantityLike() + 1);
            } else {
                qualification.get().setQuantityDisLike(qualification.get().getQuantityDisLike() + 1);
            }
            productService.update(qualification.get());
        }

        return qualification;
    }
}
