package com.sid.app.sistema_informacion_digital.Controller;

import com.sid.app.sistema_informacion_digital.Controller.dto.ProductDto;
import com.sid.app.sistema_informacion_digital.Controller.dto.ResponseDto;
import com.sid.app.sistema_informacion_digital.Entity.Product;
import com.sid.app.sistema_informacion_digital.Entity.Reference;
import com.sid.app.sistema_informacion_digital.UseCase.ProductUseCase;
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
    ProductUseCase productUseCase;

    @GetMapping("/{ean}")
    public ResponseEntity<?> read(@PathVariable(value="ean") String ean){
        return productUseCase.findProduct(ean)
            .flatMap(product -> productUseCase.findReference(product.getReferenceId())
                .flatMap(reference -> productUseCase.findColor(product.getColorId())
                    .flatMap(color -> productUseCase.findSize(product.getSizeId())
                        .map(size -> ResponseEntity.ok(ResponseDto.builder()
                            .info(ProductDto.builder()
                                    .ean(ean)
                                    .colorName(color.getName())
                                    .colorCode(color.getCode())
                                    .sizeName(size.getName())
                                    .sizeCode(size.getCode())
                                    .codeReference(reference.getCode())
                                    .nameReference(reference.getName())
                                    .price(reference.getPrice())
                                    .build())
                            .build()))))
                )
                .orElse(ResponseEntity.badRequest()
                    .body(ResponseDto
                            .builder()
                            .error("PRODUCTO NO ENCONTRADO")
                            .build()));
    }
}
