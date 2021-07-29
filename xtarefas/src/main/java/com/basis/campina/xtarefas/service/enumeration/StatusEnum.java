package com.basis.campina.xtarefas.service.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum StatusEnum {
    EM_ANDAMENTO("Em andamento"),
    CONCLUIDO("Concluido"),
    SUSPENSO("Suspenso"),
    PARA_FAZER("Para fazer");

    private String value;
}
