package com.sid.app.sistema_informacion_digital.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "CLIENT")
public class Client  implements Serializable {

    public Client() {
    }

    public Client(String cedula, String email) {
        this.cedula = cedula;
        this.email = email;
    }

    @Id
    private String cedula;

    @Column(name = "mail", nullable = false, length = 50, unique = true)
    private String email;


    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
