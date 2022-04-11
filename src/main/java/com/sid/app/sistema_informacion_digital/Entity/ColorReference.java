package com.sid.app.sistema_informacion_digital.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "COLOR_REFERENCE")
public class ColorReference  implements Serializable {
    @Id
    private Long colorId;

    @Id
    private Long referenceId;
}
