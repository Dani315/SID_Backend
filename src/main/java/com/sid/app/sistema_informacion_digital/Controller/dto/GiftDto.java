package com.sid.app.sistema_informacion_digital.Controller.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class GiftDto {
    private String serial;
    private String state;
    private Date creationDate;
    private String userId;
}
