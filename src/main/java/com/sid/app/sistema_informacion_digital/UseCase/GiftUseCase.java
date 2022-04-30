package com.sid.app.sistema_informacion_digital.UseCase;

import com.sid.app.sistema_informacion_digital.Entity.Client;
import com.sid.app.sistema_informacion_digital.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GiftUseCase {

    @Autowired
    UserUseCase userUseCase;

    public User generate(String id, String name, String lastName, String email) {
        return userUseCase.findUser(id)
                        .orElseGet(() -> {
            userUseCase.saveClient(new User(id, name), new Client(id, email));
            return null;
        });

    }


}
