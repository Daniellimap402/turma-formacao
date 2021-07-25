package com.basis.campina.xtarefas.service.event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnexoEvent extends DefaultEvent{
    public AnexoEvent(Long id) {
        super(id);
    }
}
