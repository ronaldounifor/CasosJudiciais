package br.cnj.casosjudiciais.controller;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.cnj.casosjudiciais.model.CasoJudicial;
import br.cnj.casosjudiciais.service.CasoJudicialService;

@RestController
@RequestMapping("/api/casos")
public class CasoJudicialController {

    private final CasoJudicialService service;

    public CasoJudicialController(CasoJudicialService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CasoJudicial>> pegarTodosOsCasos() {
        List<CasoJudicial> casos = service.listarCasos();
        return ResponseEntity.ok(casos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CasoJudicial> pegarCasoPorID(@PathVariable Integer id) {
        CasoJudicial caso = service.encontrarCasoPorId(id);
        return ResponseEntity.ok(caso);
    }

    @PostMapping
    public ResponseEntity<CasoJudicial> criarCaso(@RequestBody CasoJudicial novoCaso) {
        service.salvarCaso(novoCaso);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(novoCaso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCaso(@PathVariable Integer id) {
        service.excluirCaso(id);
        return ResponseEntity.noContent().build();
    }
}
