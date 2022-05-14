package com.sid.app.sistema_informacion_digital.Repository;

import com.sid.app.sistema_informacion_digital.Entity.Client;
import com.sid.app.sistema_informacion_digital.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository  extends JpaRepository<Client, String> {

    List<Client> findByCedulaOrEmail(String id, String email);
}
