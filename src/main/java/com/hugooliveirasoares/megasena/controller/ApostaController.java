package com.hugooliveirasoares.megasena.controller;

import com.hugooliveirasoares.megasena.entity.ApostaEntity;
import com.hugooliveirasoares.megasena.service.ApostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("apostas")
public class ApostaController {

    @Autowired
    private ApostaService apostaService;

    @PostMapping(path = "/novaaposta")
    public ResponseEntity<ApostaEntity> addNewUser(@RequestBody ApostaEntity apostaEntity) {
        return new ResponseEntity<>(apostaService.requestNewBet(apostaEntity), HttpStatus.CREATED);
    }

    @GetMapping("/getbyemail")
    public ResponseEntity<List<ApostaEntity>> getByEmail(@RequestParam String email){
        return ResponseEntity.ok(apostaService.getByEmail(email));
    }

    @GetMapping(path = "/all")
    public Iterable<ApostaEntity> getAllUsers() {
        return apostaService.findAll();
    }

}
