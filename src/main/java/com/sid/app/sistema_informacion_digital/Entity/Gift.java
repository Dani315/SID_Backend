package com.sid.app.sistema_informacion_digital.Entity;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "GIFT")
public class Gift  implements Serializable {

    public Gift() {
    }

    public Gift(String serial, String usuarioId, String state, Date creationDate) {
        this.serial = serial;
        this.usuarioId = usuarioId;
        this.state = state;
        this.creationDate = creationDate;
    }

    @Id
    private String serial;

    @Column
    private String usuarioId;

    @Column
    private String state;

    @Column
    private Date creationDate;

    @Column
    private Date actualizationDate;

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getActualizationDate() {
        return actualizationDate;
    }

    public void setActualizationDate(Date actualizationDate) {
        this.actualizationDate = actualizationDate;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public String getState() {
        return state;
    }

    public Date getCreationDate() {
        return creationDate;
    }
}
