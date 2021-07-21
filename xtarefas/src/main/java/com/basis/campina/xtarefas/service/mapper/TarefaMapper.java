package com.basis.campina.xtarefas.service.mapper;

import com.basis.campina.xtarefas.domain.Tarefa;
import com.basis.campina.xtarefas.service.dto.TarefaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AnexoMapper.class, ResponsavelMapper.class})
public interface TarefaMapper {

    @Mapping(source = "idResponsavel", target = "responsavel.id")
    Tarefa toEntity(TarefaDTO tarefaDTO);

    @Mapping(source = "responsavel.id", target = "idResponsavel")
    TarefaDTO toDto(Tarefa tarefa);

}
