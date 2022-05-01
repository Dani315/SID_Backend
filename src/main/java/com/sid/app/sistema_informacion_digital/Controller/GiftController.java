package com.sid.app.sistema_informacion_digital.Controller;

import com.sid.app.sistema_informacion_digital.Controller.dto.GiftDto;
import com.sid.app.sistema_informacion_digital.Controller.dto.ResponseDto;
import com.sid.app.sistema_informacion_digital.Controller.dto.UserDto;
import com.sid.app.sistema_informacion_digital.Entity.Gift;
import com.sid.app.sistema_informacion_digital.Entity.User;
import com.sid.app.sistema_informacion_digital.UseCase.GiftUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
                                    @RequestParam(value="email") String email) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(giftUseCase.generate(id, name, lastName, email));
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
