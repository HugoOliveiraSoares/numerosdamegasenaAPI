package com.hugooliveirasoares.megasena.service;

import com.hugooliveirasoares.megasena.entity.ApostaEntity;
import com.hugooliveirasoares.megasena.entity.BetNumbers;
import com.hugooliveirasoares.megasena.repository.ApostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ApostaService {

    @Autowired
    private ApostaRepository apostaRepository;

    public ApostaEntity requestNewBet(ApostaEntity apostaEntity){
        apostaEntity.setNumbers(generateRandomNumber());
        return apostaRepository.save(apostaEntity);
    }

    public List<ApostaEntity> getByEmail(String email){
        return apostaRepository.findByEmail(email);
    }

    public String generateRandomNumber(){
        Random generateNumber = new Random();
        String numbersDrawn = "";
        for (int i = 0; i < 6; i++) {
            numbersDrawn += " "+ generateNumber.nextInt(60);
        }
        return numbersDrawn;
    }

    public Iterable<ApostaEntity> findAll() {
        return apostaRepository.findAll();
    }
}
