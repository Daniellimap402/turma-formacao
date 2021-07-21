package com.basis.campina.xtarefas.service.dto;

import com.basis.campina.xtarefas.service.enumeration.StatusEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class TarefaDTO {

    private Long id;

    private String nome;

    private LocalDate dataConclusao;

    private LocalDate dataInicio;

    private StatusEnum status;

    private List<AnexoDTO> anexos;

    private Long idResponsavel;
}
