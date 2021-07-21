package com.basis.campina.xtarefas.service.mapper;

import com.basis.campina.xtarefas.domain.Anexo;
import com.basis.campina.xtarefas.service.dto.AnexoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface AnexoMapper {

    Anexo toEntity(AnexoDTO dto);

    AnexoDTO toDto(Anexo anexo);

}
