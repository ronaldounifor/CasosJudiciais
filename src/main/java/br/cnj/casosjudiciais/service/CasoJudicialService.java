package br.cnj.casosjudiciais.service;

import java.util.List;
import br.cnj.casosjudiciais.model.CasoJudicial;
import br.cnj.casosjudiciais.repository.CasoJudicialRepository;

import org.springframework.stereotype.Service;

@Service
public class CasoJudicialService {
    
    private final CasoJudicialRepository casoRepository;

    public CasoJudicialService(CasoJudicialRepository casoRepository) {
        this.casoRepository = casoRepository;
    }
    
    public List<CasoJudicial> listarCasos() {
        return casoRepository.findAll();
    }

    public CasoJudicial encontrarCasoPorId(int id) {
        return casoRepository.getReferenceById(id);
    }

    public void salvarCaso(CasoJudicial caso) {
        casoRepository.save(caso);
    }

    public void excluirCaso(int id) {
        casoRepository.delete(encontrarCasoPorId(id));
    }
}
