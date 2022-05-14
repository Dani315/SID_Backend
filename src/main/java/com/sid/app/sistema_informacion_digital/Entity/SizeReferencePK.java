package com.sid.app.sistema_informacion_digital.Entity;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class SizeReferencePK implements Serializable {

    private Long sizeId;

    private Long referenceId;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.sizeId);
        hash = 59 * hash + Objects.hashCode(this.referenceId);
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
        final SizeReferencePK other = (SizeReferencePK) obj;
        if (!Objects.equals(this.referenceId, other.referenceId)) {
            return false;
        }
        if (!Objects.equals(this.sizeId, other.sizeId)) {
            return false;
        }
        return true;
    }
}
