package com.sid.app.sistema_informacion_digital.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "LOCATION_PRODUCT")
public class LocationProduct  implements Serializable {

    @Id
    private Long locationId;

    @Id
    private String productId;

    @Column
    private Integer stock;
}
