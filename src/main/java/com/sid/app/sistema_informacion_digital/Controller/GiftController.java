package com.sid.app.sistema_informacion_digital.Controller;

import com.sid.app.sistema_informacion_digital.Entity.User;
import com.sid.app.sistema_informacion_digital.UseCase.GiftUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
