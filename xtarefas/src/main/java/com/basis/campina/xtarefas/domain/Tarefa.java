package com.basis.campina.xtarefas.domain;

import com.basis.campina.xtarefas.service.enumeration.StatusEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_tarefa")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(name = "dt_conclusao")
    private LocalDate dataConclusao;

    @Column(name = "dt_inicio")
    private LocalDate dataInicio;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tarefa_id")
    private List<Anexo> anexos;

    @ManyToOne(fetch = FetchType.LAZY)
    private Responsavel responsavel;

}
