package br.cnj.casosjudiciais.dto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.cnj.casosjudiciais.model.CasoJudicial;

@Mapper(componentModel = "spring")
public interface CasoJudicialMapper {

    CasoJudicialMapper INSTANCE = Mappers.getMapper(CasoJudicialMapper.class);

    @Mapping(source = "numero", target = "numero")
    @Mapping(source = "decisao", target = "decisao")
    @Mapping(source = "descricao", target = "descricao")
    CasoJudicialDTO casoJudicialToDTO(CasoJudicial casoJudicial);

    @Mapping(source = "numero", target = "numero")
    @Mapping(source = "decisao", target = "decisao")
    @Mapping(source = "descricao", target = "descricao")
    CasoJudicial dtoToCasoJudicial(CasoJudicialDTO casoJudicialDTO);

    List<CasoJudicialDTO> casosToCasosDTO(List<CasoJudicial> casos);
}