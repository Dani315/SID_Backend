package com.sid.app.sistema_informacion_digital.UseCase;

import com.sid.app.sistema_informacion_digital.Entity.Client;
import com.sid.app.sistema_informacion_digital.Entity.Gift;
import com.sid.app.sistema_informacion_digital.Entity.User;
import com.sid.app.sistema_informacion_digital.Service.gift.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@Component
public class GiftUseCase {

    @Autowired
    UserUseCase userUseCase;

    @Autowired
    GiftService giftService;

    public User generate(String id, String name, String lastName, String email) {
        return userUseCase.findUser(id)
                .orElseGet(() -> {
                    userUseCase.saveClient(new User(id, name), new Client(id, email));
                    return null;
                });

    }

    public Optional<Gift> find(String idGift) {
        return giftService.findById(idGift);
    }

    public Optional<Gift> updateGift(String idGift){
        Optional<Gift> gift = find(idGift);
        if(gift.isPresent()){
            gift.get().setState("NO DISPONIBLE");
            gift.get().setActualizationDate(Date.valueOf(LocalDate.now()));
            giftService.save(gift.get());
        }
        return gift;
    }

}
