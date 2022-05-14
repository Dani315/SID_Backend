package com.sid.app.sistema_informacion_digital.UseCase;

import com.sid.app.sistema_informacion_digital.Entity.Client;
import com.sid.app.sistema_informacion_digital.Entity.Enumerable.StateGift;
import com.sid.app.sistema_informacion_digital.Entity.Gift;
import com.sid.app.sistema_informacion_digital.Entity.User;
import com.sid.app.sistema_informacion_digital.Helpers.GenerateAlphaNumericString;
import com.sid.app.sistema_informacion_digital.Service.email.EmailSenderService;
import com.sid.app.sistema_informacion_digital.Service.gift.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Component
public class GiftUseCase {

    @Autowired
    UserUseCase userUseCase;

    @Autowired
    GiftService giftService;

    @Autowired
    ClientUseCase clientUseCase;

    @Autowired
    GenerateAlphaNumericString generateAlpha;

    @Autowired
    EmailSenderService emailSenderService;

    public Optional<Client> generate(String id, String name, String lastName, String email) {

       return Optional.ofNullable(clientUseCase.findClient(id, email)
               .stream()
               .findAny()
               .orElseGet(() -> {
                   userUseCase.saveClient(new User(id, name+" " +lastName), new Client(id, email));

                   emailSenderService.enviarConGMail(email,
                           "¡BONO DESCUENTO TIENDA GEF!",
                           this.save(id));

                   return null;
               }));

    }

    public Optional<Gift> find(String idGift) {
      return giftService.findById(idGift);
    }

    public Optional<Gift> findByUser(String idUser) {
        return giftService.findById(idUser);
    }

    public String save(String idUser) {
        String idGift = generateAlpha.getRandomString(10);

        giftService.save(new Gift(idGift,
                idUser,
                StateGift.DISPONIBLE.name(),
                Date.valueOf(LocalDate.now())));

        return idGift;
    }

}
