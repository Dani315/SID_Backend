package com.sid.app.sistema_informacion_digital.Service;

import com.sid.app.sistema_informacion_digital.Entity.Client;
import com.sid.app.sistema_informacion_digital.Entity.Employee;
import com.sid.app.sistema_informacion_digital.Entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> findAll();

    public Page<User> findAll(Pageable pageable);

    public Optional<User> findById(String id);

    public void save(User user);

    public void deleteById(String id);

    public Client saveClient(Client client);;

    public List<Client> findClient(String id, String email);

    @Transactional(readOnly = true)
    Optional<Employee> findEmployeeById(String id);
}
