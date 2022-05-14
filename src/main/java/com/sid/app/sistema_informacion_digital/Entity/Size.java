package com.sid.app.sistema_informacion_digital.Entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SIZE")
public class Size  implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long code;

    @Column
    private String name;

    public Long getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
