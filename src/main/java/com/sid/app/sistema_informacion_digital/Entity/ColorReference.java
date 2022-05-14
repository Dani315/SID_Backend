package com.sid.app.sistema_informacion_digital.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "COLOR_REFERENCE")
@IdClass(value = ColorReferencePK.class)
public class ColorReference  implements Serializable {
    @Id
    private Long colorId;

    @Id
    private Long referenceId;

    public Long getColorId() {
        return colorId;
    }

    public Long getReferenceId() {
        return referenceId;
    }
}
