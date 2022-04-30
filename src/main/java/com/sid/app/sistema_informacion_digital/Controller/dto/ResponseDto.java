package com.sid.app.sistema_informacion_digital.Controller.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseDto<E> {

    public E info;

    public String error;

}
