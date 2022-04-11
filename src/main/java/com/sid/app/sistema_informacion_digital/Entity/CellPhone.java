package com.sid.app.sistema_informacion_digital.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CELLPHONE")
public class CellPhone  implements Serializable {

    @Id
    @Column(length = 10)
    private String number;

    @Column
    private Long locationId;

}
