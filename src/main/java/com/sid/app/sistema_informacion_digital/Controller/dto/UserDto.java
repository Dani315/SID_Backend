package com.sid.app.sistema_informacion_digital.Controller.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDto {
    public String name;
    public String cedula;
}
