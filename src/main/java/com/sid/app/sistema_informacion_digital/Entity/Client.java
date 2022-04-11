package com.sid.app.sistema_informacion_digital.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "CLIENT")
public class Client  implements Serializable {

    @Id
    private String cedula;

    @Column(name = "mail", nullable = false, length = 50, unique = true)
    private String email;

}
