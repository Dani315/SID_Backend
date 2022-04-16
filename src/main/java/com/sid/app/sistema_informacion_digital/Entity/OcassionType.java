package com.sid.app.sistema_informacion_digital.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "OCASSION_TYPE")
public class OcassionType  implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long code;

    @Column
    private String  name;

}
