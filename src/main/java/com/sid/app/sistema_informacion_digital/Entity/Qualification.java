package com.sid.app.sistema_informacion_digital.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "QUALIFICATION")
public class Qualification  implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long code;

    @Column
    private Integer quantityLike;

    @Column
    private Integer quantityDisLike;

    public Long getCode() {
        return code;
    }

    public Integer getQuantityLike() {
        return quantityLike;
    }

    public Integer getQuantityDisLike() {
        return quantityDisLike;
    }
}
