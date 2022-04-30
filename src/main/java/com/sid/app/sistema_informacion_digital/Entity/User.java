package com.sid.app.sistema_informacion_digital.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "USER")
public class User implements Serializable {
    public User() {
    }

    public User(String cedula, String name) {
        this.cedula = cedula;
        this.name = name;
    }

    @Id
    private String cedula;

    @Column(length = 50)
    private String name;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
