package com.sid.app.sistema_informacion_digital.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "LOCATION_PRODUCT")
@IdClass(value = LocationProductPK.class)
public class LocationProduct  implements Serializable {

    @Id
    private Long locationId;

    @Id
    private String productId;

    @Column
    private Integer stock;

    public Long getLocationId() {
        return locationId;
    }

    public String getProductId() {
        return productId;
    }

    public Integer getStock() {
        return stock;
    }
}
