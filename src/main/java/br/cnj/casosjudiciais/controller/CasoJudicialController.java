package br.cnj.casosjudiciais.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.cnj.casosjudiciais.dto.CasoJudicialDTO;
import br.cnj.casosjudiciais.dto.CasoJudicialMapper;
import br.cnj.casosjudiciais.model.CasoJudicial;
import br.cnj.casosjudiciais.service.CasoJudicialService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/casos")
public class CasoJudicialController {

    private static final Logger logger = LogManager.getLogger(CasoJudicialController.class);
    private final CasoJudicialService service;
    private final CasoJudicialMapper mapper;

    public CasoJudicialController(CasoJudicialService service, CasoJudicialMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Operation(summary = "Recupera todos os casos judiciais", method = "GET") 
    @ApiResponses(value = { 
                  @ApiResponse(responseCode = "200", description = "Casos recuperados com sucesso"), 
                  @ApiResponse(responseCode = "500", description = "Erro!")}) 
    @GetMapping
    public ResponseEntity<List<CasoJudicialDTO>> pegarTodosOsCasos() {
        logger.info("Pegar todos os casos");
        return new ResponseEntity<>(mapper.casosToCasosDTO(service.listarCasos()), HttpStatus.OK);
    }

    @Operation(summary = "Recupera um casos judiciais pelo ID", method = "GET") 
    @ApiResponses(value = { 
                  @ApiResponse(responseCode = "200", description = "Caso recuperado com sucesso"), 
                  @ApiResponse(responseCode = "500", description = "Erro!")}) 
    @GetMapping("/{id}")
    public ResponseEntity<CasoJudicialDTO> pegarCasoPorID(@PathVariable Integer id) {
        logger.info("Pegar caso de numero '{}''.", id);
        CasoJudicial caso = service.encontrarCasoPorId(id);
        return ResponseEntity.ok(mapper.casoJudicialToDTO(caso));
    }

    @Operation(summary = "Registra um novo caso judicial", method = "POST") 
    @ApiResponses(value = { 
                  @ApiResponse(responseCode = "200", description = "Caso registrado com sucesso"), 
                  @ApiResponse(responseCode = "500", description = "Erro!")}) 
    @PostMapping
    public ResponseEntity<CasoJudicialDTO> criarCaso(@RequestBody CasoJudicialDTO novoCaso) {
        logger.info("Salvar caso de numero '{}''.", novoCaso.getNumero());
        service.salvarCaso(mapper.dtoToCasoJudicial(novoCaso));
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(novoCaso);
    }

    @Operation(summary = "Remove um casos judiciais pelo ID", method = "GET") 
    @ApiResponses(value = { 
                  @ApiResponse(responseCode = "204", description = "Caso removido com sucesso"), 
                  @ApiResponse(responseCode = "500", description = "Erro!")}) 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCaso(@PathVariable Integer id) {
        logger.info("Remover caso de numero '{}''.", id);
        service.excluirCaso(id);
        return ResponseEntity.noContent().build();
    }
}
