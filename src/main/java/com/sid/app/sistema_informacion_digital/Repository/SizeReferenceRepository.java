package com.sid.app.sistema_informacion_digital.Repository;

import com.sid.app.sistema_informacion_digital.Entity.SizeReference;
import com.sid.app.sistema_informacion_digital.Entity.SizeReferencePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SizeReferenceRepository  extends JpaRepository<SizeReference, SizeReferencePK> {
    List<SizeReference> findAllByReferenceId(Long referenceId);
}
