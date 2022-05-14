package com.sid.app.sistema_informacion_digital.Controller;

import com.sid.app.sistema_informacion_digital.Controller.dto.*;
import com.sid.app.sistema_informacion_digital.Entity.Product;
import com.sid.app.sistema_informacion_digital.Entity.Reference;
import com.sid.app.sistema_informacion_digital.UseCase.ProductUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
                                    .color(DetalleDto.builder()
                                            .code(color.getCode())
                                            .name(color.getName())
                                            .build())
                                    .size(DetalleDto.builder()
                                            .code(size.getCode())
                                            .name(size.getName())
                                            .build())
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

    @GetMapping("images/{ean}")
    public ResponseEntity<?> readImagesEan(@PathVariable(value="ean") String ean){
        List<ImageDto> imageDtoList = productUseCase.findAllImagesByProduct(ean)
                .stream().map(image -> ImageDto.builder()
                        .code(image.getCode())
                        .productId(image.getProductId())
                        .url(image.getUrl())
                        .build()).collect(Collectors.toList());

        return  ResponseEntity.ok(ResponseDto.builder()
                .info(imageDtoList)
                .build());
    }

    @GetMapping("talla-referencia/{referenceId}")
    public ResponseEntity<?> readReferenceSize(@PathVariable(value="referenceId") Long referenceId){
        List<DetalleDto> sizeReferenceList = productUseCase.findAllSizeReferenceByProduct(referenceId)
                .stream()
                .map(sizeReference -> DetalleDto.builder()
                        .code(sizeReference.getCode())
                        .name(sizeReference.getName())
                        .build())
                .collect(Collectors.toList());

        return  ResponseEntity.ok(ResponseDto.builder()
                .info(sizeReferenceList)
                .build());

    }
}
