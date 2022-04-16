package com.sid.app.sistema_informacion_digital.Repository;

import com.sid.app.sistema_informacion_digital.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}

