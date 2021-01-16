package com.hugooliveirasoares.megasena.service;

import com.hugooliveirasoares.megasena.entity.BetEntity;
import com.hugooliveirasoares.megasena.repository.BetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BetService {

    @Autowired
    private BetRepository betRepository;

    public BetEntity requestNewBet(BetEntity betEntity){
        betEntity.setNumbers(generateRandomNumber());
        return betRepository.save(betEntity);
    }

    public List<BetEntity> getByEmail(String email){
        return betRepository.findByEmail(email);
    }

    public String generateRandomNumber(){
        Random generateNumber = new Random();
        String numbersDrawn = "";
        for (int i = 0; i < 6; i++) {
            numbersDrawn += " "+ generateNumber.nextInt(60);
        }
        return numbersDrawn;
    }

    public Iterable<BetEntity> findAll() {
        return betRepository.findAll();
    }
}
