package com.sid.app.sistema_informacion_digital.Entity;

import java.io.Serializable;
import java.util.Objects;

public class ColorReferencePK  implements Serializable {

    private Long colorId;

    private Long referenceId;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.colorId);
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
        final ColorReferencePK other = (ColorReferencePK) obj;
        if (!Objects.equals(this.referenceId, other.referenceId)) {
            return false;
        }
        if (!Objects.equals(this.colorId, other.colorId)) {
            return false;
        }
        return true;
    }
}
