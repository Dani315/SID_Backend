package com.sid.app.sistema_informacion_digital.Service.gift;

import com.sid.app.sistema_informacion_digital.Entity.Gift;
import com.sid.app.sistema_informacion_digital.Repository.GiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class GiftServiceImpl implements GiftService {

    @Autowired
    private GiftRepository giftRepository;

    @Override
    public Optional<Gift> findById(String id) {
        return giftRepository.findById(id);
    }
    @Override
    @Transactional
    public void save(Gift gift) {
        giftRepository.save(gift);
    }

}
