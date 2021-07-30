package com.basis.campina.xtarefas.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DominioFixoDTO implements Serializable {

    private static final long serialVersionUID = -6786788218042581068L;

    private Long value;

    private String label;

}
