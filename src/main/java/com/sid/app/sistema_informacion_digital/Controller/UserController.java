package com.sid.app.sistema_informacion_digital.Controller;


import com.sid.app.sistema_informacion_digital.Controller.dto.ResponseDto;
import com.sid.app.sistema_informacion_digital.Controller.dto.UserDto;
import com.sid.app.sistema_informacion_digital.Entity.Employee;
import com.sid.app.sistema_informacion_digital.Entity.User;
import com.sid.app.sistema_informacion_digital.Service.UserService;
import com.sid.app.sistema_informacion_digital.UseCase.UserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserUseCase userUseCase;

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET,  produces="application/json")
    public  ResponseEntity<ResponseDto> read(@PathVariable(value="id") String userId){

        Optional<Employee> oUser = userUseCase.findEmployee(userId);

        if(oUser.isEmpty()) {
            return  ResponseEntity.badRequest()
                    .body(ResponseDto.builder()
                            .error("ESTE EMPLEADO NO EXISTE")
                            .build());
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(ResponseDto.builder()
                        .info(UserDto.builder()
                                .cedula(oUser.get()
                                        .getCedula())
                                .name(oUser.get()
                                        .getPosition())
                                .build())
                        .build()
                );
    }

}
