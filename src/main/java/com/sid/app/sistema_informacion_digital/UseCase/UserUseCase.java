package com.sid.app.sistema_informacion_digital.UseCase;

import com.sid.app.sistema_informacion_digital.Entity.Client;
import com.sid.app.sistema_informacion_digital.Entity.User;
import com.sid.app.sistema_informacion_digital.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserUseCase {

    @Autowired
    private UserService userService;


    public void saveClient(User user, Client client) {
        try {
            userService.save(user);
            userService.saveClient(client);
        }catch (Exception e) {
            throw new RuntimeException("A ESTE CORREO YA SE HA NOTIFICADO UN BONO");
        }

    }

    public Optional<User> findUser(String userId) {
        return userService.findById(userId);
    }

}