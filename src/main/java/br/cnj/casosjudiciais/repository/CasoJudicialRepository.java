package br.cnj.casosjudiciais.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.cnj.casosjudiciais.model.CasoJudicial;

@Repository
public interface CasoJudicialRepository extends JpaRepository<CasoJudicial, Integer> {
    
}
