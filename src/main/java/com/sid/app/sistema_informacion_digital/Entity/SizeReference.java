package com.sid.app.sistema_informacion_digital.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "SIZE_REFERENCE")
public class SizeReference  implements Serializable {

    @Id
    private Long sizeId;

    @Id
    private Long referenceId;
}
