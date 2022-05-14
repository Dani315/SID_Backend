package com.sid.app.sistema_informacion_digital.Repository;

import com.sid.app.sistema_informacion_digital.Entity.ColorReference;
import com.sid.app.sistema_informacion_digital.Entity.ColorReferencePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColorReferenceRepository  extends JpaRepository<ColorReference, ColorReferencePK> {
    List<ColorReference> findAllByReferenceId(Long referenceId);
}
