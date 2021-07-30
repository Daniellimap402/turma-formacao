package com.basis.campina.xtarefas.test.build;

import com.basis.campina.xtarefas.domain.Tarefa;
import com.basis.campina.xtarefas.repository.elastic.TarefaSearchRepository;
import com.basis.campina.xtarefas.service.TarefaService;
import com.basis.campina.xtarefas.service.dto.TarefaDTO;
import com.basis.campina.xtarefas.service.mapper.TarefaMapper;
import com.basis.campina.xtarefas.util.ConstantsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

@Component
public class TarefaBuilder extends ConstrutorEntidade<Tarefa> {

    @Autowired
    private ResponsavelBuilder responsavelBuilder;

    @Autowired
    private AnexoBuilder anexoBuilder;

    @Autowired
    private TarefaService service;

    @Autowired
    private TarefaMapper mapper;

    @Autowired
    private TarefaSearchRepository repository;

    @Override
    public Tarefa construirEntidade() throws ParseException {
        Tarefa tarefa = new Tarefa();
        tarefa.setNome(ConstantsUtil.TEXTO_PADRAO);
        tarefa.setResponsavel(responsavelBuilder.construir());
        tarefa.setAnexos(Collections.singletonList(anexoBuilder.construirEntidade()));
        tarefa.setDataInicio(LocalDate.now().minusYears(1));
        tarefa.setDataConclusao(LocalDate.now());
        return tarefa;
    }

    public TarefaDTO construirDto() throws ParseException {
        return mapper.toDto(construirEntidade());
    }

    @Override
    protected Tarefa persistir(Tarefa entidade) {
        return this.mapper.toEntity(this.service.salvar(this.mapper.toDto(entidade)));
    }

    @Override
    protected Collection<Tarefa> obterTodos() {
        return null;
    }

    @Override
    protected Tarefa obterPorId(Long id) {
        return null;
    }
}
