package com.sid.app.sistema_informacion_digital.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "QUALIFICATION")
public class Qualification  implements Serializable {

    public Qualification() {
    }

    public Qualification(Long code, Integer quantityLike, Integer quantityDisLike) {
        this.code = code;
        this.quantityLike = quantityLike;
        this.quantityDisLike = quantityDisLike;
    }

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

    public void setCode(Long code) {
        this.code = code;
    }

    public void setQuantityLike(Integer quantityLike) {
        this.quantityLike = quantityLike;
    }

    public void setQuantityDisLike(Integer quantityDisLike) {
        this.quantityDisLike = quantityDisLike;
    }
}
