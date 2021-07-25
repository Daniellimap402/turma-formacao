package com.basis.campina.xtarefas.service.event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponsavelEvent extends DefaultEvent{
    public ResponsavelEvent(Long id) {
        super(id);
    }
}
