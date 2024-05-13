package br.cnj.casosjudiciais.controller;

import java.util.List;

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

@RestController
@RequestMapping("/api/casos")
public class CasoJudicialController {

    private final CasoJudicialService service;
    private final CasoJudicialMapper mapper;

    public CasoJudicialController(CasoJudicialService service, CasoJudicialMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<CasoJudicialDTO>> pegarTodosOsCasos() {
        return new ResponseEntity<>(mapper.casosToCasosDTO(service.listarCasos()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CasoJudicialDTO> pegarCasoPorID(@PathVariable Integer id) {
        CasoJudicial caso = service.encontrarCasoPorId(id);
        return ResponseEntity.ok(mapper.casoJudicialToDTO(caso));
    }

    @PostMapping
    public ResponseEntity<CasoJudicialDTO> criarCaso(@RequestBody CasoJudicialDTO novoCaso) {
        service.salvarCaso(mapper.dtoToCasoJudicial(novoCaso));
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(novoCaso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCaso(@PathVariable Integer id) {
        service.excluirCaso(id);
        return ResponseEntity.noContent().build();
    }
}
