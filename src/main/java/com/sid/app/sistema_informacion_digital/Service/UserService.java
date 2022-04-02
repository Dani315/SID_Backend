package com.sid.app.sistema_informacion_digital.Service;

import com.sid.app.sistema_informacion_digital.Entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> findAll();

    public Page<User> findAll(Pageable pageable);

    public Optional<User> findById(Long id);

    public User save(User user);

    public void deleteById(Long id);

}
