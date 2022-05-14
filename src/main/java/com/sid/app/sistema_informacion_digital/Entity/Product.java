package com.sid.app.sistema_informacion_digital.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {

    @Id
    @Column(length = 13)
    private String EAN;

    @Column
    private Long ocassionTypeId;

    @Column
    private Long qualificationId;

    @Column
    private Long referenceId;

    @Column
    private Long colorId;

    @Column
    private Long sizeId;

    public String getEAN() {
        return EAN;
    }

    public Long getOcassionTypeId() {
        return ocassionTypeId;
    }

    public Long getQualificationId() {
        return qualificationId;
    }

    public Long getReferenceId() {
        return referenceId;
    }

    public Long getColorId() {
        return colorId;
    }

    public Long getSizeId() {
        return sizeId;
    }
}
