package com.sid.app.sistema_informacion_digital.Entity;

import java.io.Serializable;
import java.util.Objects;

public class LocationProductPK  implements Serializable {
    private Long locationId;

    private String productId;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.locationId);
        hash = 59 * hash + Objects.hashCode(this.productId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LocationProductPK other = (LocationProductPK) obj;
        if (!Objects.equals(this.locationId, other.locationId)) {
            return false;
        }
        if (!Objects.equals(this.productId, other.productId)) {
            return false;
        }
        return true;
    }

    public Long getLocationId() {
        return locationId;
    }

    public String getProductId() {
        return productId;
    }
}
