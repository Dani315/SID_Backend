package com.sid.app.sistema_informacion_digital.Repository;

import com.sid.app.sistema_informacion_digital.Entity.CellPhone;
import com.sid.app.sistema_informacion_digital.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CellPhoneRepository extends JpaRepository<CellPhone, String> {
}
