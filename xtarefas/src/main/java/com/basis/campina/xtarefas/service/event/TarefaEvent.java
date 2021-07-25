package com.basis.campina.xtarefas.service.event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TarefaEvent extends DefaultEvent{
    public TarefaEvent(Long id) {
        super(id);
    }
}
