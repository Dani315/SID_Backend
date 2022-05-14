package com.sid.app.sistema_informacion_digital.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "EMPLOYEE")
public class Employee  implements Serializable {

    @Id
    private String cedula;

    @Column
    private String position;

    public String getCedula() {
        return cedula;
    }

    public String getPosition() {
        return position;
    }
}
