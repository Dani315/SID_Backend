package com.sid.app.sistema_informacion_digital.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "COLOR")
public class Color  implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long code;

    @Column
    private String name;

    @Column
    private String palette;

    public Long getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getPalette() {
        return palette;
    }
}
