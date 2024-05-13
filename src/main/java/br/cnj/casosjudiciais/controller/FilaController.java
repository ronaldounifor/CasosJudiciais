package br.cnj.casosjudiciais.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.cnj.casosjudiciais.messaging.Producer;

@RestController
@RequestMapping("/api/fila")
public class FilaController {
    @Autowired
    private Producer producer;

    @PostMapping
    public ResponseEntity<String> enviarMensagem(@RequestBody String mensagem) {
        producer.send(mensagem);
        return ResponseEntity.ok("Mensagem '"+mensagem+"' enviada para a fila com sucesso.");
    }
}