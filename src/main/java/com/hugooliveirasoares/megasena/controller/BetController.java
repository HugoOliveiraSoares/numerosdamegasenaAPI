package com.hugooliveirasoares.megasena.controller;

import com.hugooliveirasoares.megasena.entity.BetEntity;
import com.hugooliveirasoares.megasena.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("apostas")
public class BetController {

    @Autowired
    private BetService betService;

    @PostMapping(path = "/newbet")
    public ResponseEntity<BetEntity> addNewUser(@RequestBody BetEntity betEntity) {
        return new ResponseEntity<>(betService.requestNewBet(betEntity), HttpStatus.CREATED);
    }

    @GetMapping("/getbyemail")
    public ResponseEntity<List<BetEntity>> getByEmail(@RequestParam String email){
        return ResponseEntity.ok(betService.getByEmail(email));
    }

    @GetMapping(path = "/all")
    public Iterable<BetEntity> getAllUsers() {
        return betService.findAll();
    }

}
