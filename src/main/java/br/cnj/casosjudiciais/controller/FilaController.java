package br.cnj.casosjudiciais.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.cnj.casosjudiciais.messaging.Producer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/fila")
public class FilaController {
    @Autowired
    private Producer producer;

    @Operation(summary = "Produz uma mensagem para a fila de processamento", method = "POST") 
    @ApiResponses(value = { 
                  @ApiResponse(responseCode = "200", description = "Mensagem enviada com sucesso"), 
                  @ApiResponse(responseCode = "500", description = "Erro!")}) 

    @PostMapping
    public ResponseEntity<String> enviarMensagem(@RequestBody String mensagem) {
        producer.send(mensagem);
        return ResponseEntity.ok("Mensagem '"+mensagem+"' enviada para a fila com sucesso.");
    }
}