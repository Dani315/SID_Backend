package com.sid.app.sistema_informacion_digital.Controller;


import com.sid.app.sistema_informacion_digital.Entity.User;
import com.sid.app.sistema_informacion_digital.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    //Create a new user
    @PostMapping
    public ResponseEntity<?> create(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.save(user));
    }

    @GetMapping("/{id}")
    public  ResponseEntity<?> read(@PathVariable(value="id") Long userId){
        Optional<User> oUser = userService.findById(userId);

        if(oUser.isEmpty()) {
            return  ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(oUser);
    }

}
