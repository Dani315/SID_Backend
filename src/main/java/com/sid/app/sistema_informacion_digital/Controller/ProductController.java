package com.sid.app.sistema_informacion_digital.Controller;

import com.sid.app.sistema_informacion_digital.Controller.dto.*;
import com.sid.app.sistema_informacion_digital.Entity.*;
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
                                .info(getBuild(ean, product, reference, color, size))
                                .build()
                        ))))
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
        List<SizeDto> sizeReferenceList = productUseCase.findAllSizeReferenceByProduct(referenceId)
                .stream()
                .map(sizeReference -> SizeDto.builder()
                        .code(sizeReference.getCode())
                        .name(sizeReference.getName())
                        .build())
                .collect(Collectors.toList());

        return  ResponseEntity.ok(ResponseDto.builder()
                .info(sizeReferenceList)
                .build());

    }
    @GetMapping("color-referencia/{referenceId}")
    public ResponseEntity<?> readReferenceColor(@PathVariable(value="referenceId") Long referenceId){
        List<ColorDto> colorReferenceList = productUseCase.findAllColorReferenceByProduct(referenceId)
                .stream()
                .map(colorReference -> ColorDto.builder()
                        .code(colorReference.getCode())
                        .name(colorReference.getName())
                        .palette(colorReference.getPalette())
                        .build())
                .collect(Collectors.toList());

        return  ResponseEntity.ok(ResponseDto.builder()
                .info(colorReferenceList)
                .build());

    }

    @GetMapping("ocassionType/{ocassionTypeId}")
    public ResponseEntity<?> readOcassionType(@PathVariable(value="ocassionTypeId") Long ocassionTypeId){
        return ResponseEntity.ok(ResponseDto.builder()
                .info(productUseCase.findAllByOcassionType(ocassionTypeId)
                        .stream()
                        .map(product -> productUseCase.findReference(product.getReferenceId())
                                .map(reference -> productUseCase.findColor(product.getColorId())
                                        .map(color -> productUseCase.findSize(product.getSizeId())
                                                .map(size -> productUseCase.findAllImagesByProduct(product.getEAN()).stream().findFirst()
                                                        .map(image -> OcassionTypeDto.builder()
                                                                .product(getBuild(product.getEAN(), product, reference, color, size))
                                                                .image(image.getUrl())
                                                                .build()
                                                        )
                                                )
                                        )
                                )
                        ).collect(Collectors.toList()))
                .build());

    }

    @GetMapping("qualification")
    public ResponseEntity<?> readQualificationProduct(){

        return ResponseEntity.ok(
                ResponseDto.builder()
                        .info(productUseCase.findAllProducts()
                                .stream()
                                .map(product -> productUseCase.findReference(product.getReferenceId())
                                        .flatMap(reference -> productUseCase.findColor(product.getColorId())
                                                .flatMap(color -> productUseCase.findSize(product.getSizeId())
                                                        .flatMap(size -> productUseCase.findByQualification(product.getQualificationId())
                                                                .map(qualification -> QualificationDto.builder()
                                                                                        .product(getBuild(product.getEAN(), product, reference, color, size))
                                                                                        .quantityLike(qualification.getQuantityLike())
                                                                                        .quantityDisLike(qualification.getQuantityDisLike())
                                                                                        .build()))
                                                ))
                                ).collect(Collectors.toList()))
                        .build());
    }

    @RequestMapping(value = "qualification/{qualificationId}/{type}", method = RequestMethod.PUT, produces="application/json")
    public  ResponseEntity<?> update(@PathVariable(value="qualificationId") Long qualificationId,
                                     @PathVariable(value="type") int type) {

        Optional<Qualification> oQualification = productUseCase.updateLikes(qualificationId, type);

        if(oQualification.isEmpty()) {
            return ResponseEntity.badRequest().body(
                    ResponseDto.builder()
                            .error("LA CALIFICACIÓN DE ESTE PRODUCTO NO SE ENCUENTRA")
                            .build()
            );
        }

        return ResponseEntity.ok(ResponseDto.builder()
                .info("CALIFICACIÓN ACTUALIZADA")
                .build());
    }

    private ProductDto getBuild(String ean, Product product, Reference reference, Color color, Size size) {
        return ProductDto.builder()
                    .ean(ean)
                    .color(ColorDto.builder()
                            .code(color.getCode())
                            .name(color.getName())
                            .palette(color.getPalette())
                            .build())
                    .size(SizeDto.builder()
                            .code(size.getCode())
                            .name(size.getName())
                            .build())
                    .codeReference(reference.getCode())
                    .nameReference(reference.getName())
                    .price(reference.getPrice())
                    .ocassionTypeId(product.getOcassionTypeId())
                    .qualificationId(product.getQualificationId())
                    .build();
    }
}
