package com.sid.app.sistema_informacion_digital.UseCase;

import com.sid.app.sistema_informacion_digital.Entity.Client;
import com.sid.app.sistema_informacion_digital.Entity.User;
import com.sid.app.sistema_informacion_digital.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ClientUseCase {

    @Autowired
    private UserService userService;

    public List<Client> findClient(String userId, String email) {
        return userService.findClient(userId, email);
    }

}
