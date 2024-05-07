package br.cnj.casosjudiciais.service;

import java.util.ArrayList;
import java.util.List;
import br.cnj.casosjudiciais.model.CasoJudicial;
import org.springframework.stereotype.Service;

@Service
public class CasoJudicialService {

    private ArrayList<CasoJudicial> casos = new ArrayList<>();

    public CasoJudicialService() {
    }
    
    public List<CasoJudicial> listarCasos() {
        return casos;
    }

    public CasoJudicial encontrarCasoPorId(int id) {
        for (CasoJudicial casoJudicial : casos)
            if(casoJudicial.getNumero() == id) return casoJudicial;
        
        return null;
    }

    public void salvarCaso(CasoJudicial caso) {
        casos.add(caso);
    }

    public void excluirCaso(int id) {
        CasoJudicial caso = encontrarCasoPorId(id);
        
        if(caso != null)
            casos.remove(caso);
    }
}