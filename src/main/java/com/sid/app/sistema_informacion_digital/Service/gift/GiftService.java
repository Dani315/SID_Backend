package com.sid.app.sistema_informacion_digital.Service.gift;

import com.sid.app.sistema_informacion_digital.Entity.Gift;
import com.sid.app.sistema_informacion_digital.Entity.User;

import java.util.Optional;

public interface GiftService {

    public Optional<Gift> findById(String id);

}
