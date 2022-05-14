package com.sid.app.sistema_informacion_digital.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SIZE_REFERENCE")
@IdClass(value = SizeReferencePK.class)
public class SizeReference  implements Serializable {

    @Id
    private Long sizeId;

    @Id
    private Long referenceId;

    public Long getSizeId() {
        return sizeId;
    }

    public Long getReferenceId() {
        return referenceId;
    }
}
