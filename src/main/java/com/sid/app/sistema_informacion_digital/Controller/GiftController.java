package com.sid.app.sistema_informacion_digital.Controller;

import com.sid.app.sistema_informacion_digital.Controller.dto.GiftDto;
import com.sid.app.sistema_informacion_digital.Controller.dto.ResponseDto;
import com.sid.app.sistema_informacion_digital.Entity.Client;
import com.sid.app.sistema_informacion_digital.Entity.Gift;
import com.sid.app.sistema_informacion_digital.UseCase.GiftUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/gift")
public class GiftController {

    @Autowired
    GiftUseCase giftUseCase;

    //Generate Gift
    @PostMapping
    public ResponseEntity<?> create(@RequestParam(value="id") String id,
                                    @RequestParam(value="name") String name,
                                    @RequestParam(value="lastName") String lastName,
                                    @RequestParam(value="email") String email) throws Exception {

        try {
            Optional<Client> oClient = giftUseCase.generate(id, name, lastName, email) ;

            if (oClient.isPresent()) {
                return ResponseEntity.badRequest().body(
                        ResponseDto.builder()
                                .error("EL USUARIO YA HA SOLICITADO BONO")
                                .build()
                );
            }

            return ResponseEntity.ok()
                    .body(ResponseDto.builder()
                    .info("BONO GENERADO EXITOSAMENTE, " +
                            "POR FAVOR ESTE ATENTO A SU CORREO")
                    .build());

        }catch (Exception e) {
            throw  new Exception(e.getMessage());
        }

    }

    @RequestMapping(value = "/{giftId}", method = RequestMethod.GET,  produces="application/json")
    public  ResponseEntity<?> read(@PathVariable(value="giftId") String giftId){
        Optional<Gift> oGift = giftUseCase.find(giftId);

        if(oGift.isEmpty()) {
            return ResponseEntity.badRequest().body(
                    ResponseDto.builder()
                            .error("BONO NO ENCONTRADO")
                            .build()
            );
        }

        return ResponseEntity.ok(ResponseDto.builder()
                .info(GiftDto
                        .builder()
                        .userId(oGift.get().getUsuarioId())
                        .creationDate(oGift.get().getCreationDate())
                        .serial(oGift.get().getSerial())
                        .state(oGift.get().getState())
                        .actualizationDate(oGift.get().getActualizationDate())
                        .build())
                .build());
    }

    @RequestMapping(value = "/{giftId}", method = RequestMethod.PUT,  produces="application/json")
    public  ResponseEntity<?> update(@PathVariable(value="giftId") String giftId){
        Optional<Gift> oGift = giftUseCase.updateGift(giftId);

        if(oGift.isEmpty()) {
            return ResponseEntity.badRequest().body(
                    ResponseDto.builder()
                            .error("BONO NO ENCONTRADO")
                            .build()
            );
        }

        return ResponseEntity.ok(ResponseDto.builder()
                .info(GiftDto
                        .builder()
                        .userId(oGift.get().getUsuarioId())
                        .creationDate(oGift.get().getCreationDate())
                        .serial(oGift.get().getSerial())
                        .state(oGift.get().getState())
                        .actualizationDate(oGift.get().getActualizationDate())
                        .build())
                .build());
    }

}
