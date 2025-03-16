package com.desafio_itau.desafio_itau.controller;

import com.desafio_itau.desafio_itau.model.Estatistica;
import com.desafio_itau.desafio_itau.model.Transacao;
import com.desafio_itau.desafio_itau.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping("/transacao")
    public ResponseEntity<Void> adicionarTransacao(@RequestBody Transacao transacao) {
        if (transacaoService.adicionarTransacao(transacao)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @DeleteMapping("/transacao")
    public ResponseEntity<Void> limparTransacoes() {
        transacaoService.limparTransacoes();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/estatistica")
    public ResponseEntity<Estatistica> calcularEstatisticas() {
        return new ResponseEntity<>(transacaoService.calcularEstatisticas(), HttpStatus.OK);
    }
}
