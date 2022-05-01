package com.sid.app.sistema_informacion_digital.Entity;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "GIFT")
public class Gift  implements Serializable {

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

    public String getUsuarioId() {
        return usuarioId;
    }

    public String getState() {
        return state;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getActualizationDate() {
        return actualizationDate;
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

    public void setActualizationDate(Date actualizationDate) {
        this.actualizationDate = actualizationDate;
    }
}
