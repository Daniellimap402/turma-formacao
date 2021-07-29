package com.basis.campina.xtarefas.service.elastic;

import com.basis.campina.xtarefas.domain.elasticsearch.TarefaDocument;
import com.basis.campina.xtarefas.repository.TarefaRepository;
import com.basis.campina.xtarefas.repository.elastic.TarefaSearchRepository;
import com.basis.campina.xtarefas.service.AnexoService;
import com.basis.campina.xtarefas.service.event.TarefaEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TarefaElasticsearchService {

    private final TarefaRepository repository;
    private final TarefaSearchRepository searchRepository;
    private final AnexoService anexoService;

    @TransactionalEventListener(fallbackExecution = true)
    public void reindex(TarefaEvent event){
        TarefaDocument tarefa = repository.getTarefa(event.getId());
        String nomeAnexos = anexoService.getNomeAnexosByTarefaId(event.getId()).stream().collect(Collectors.joining(", "));
        tarefa.setNomeAnexos(nomeAnexos);
        searchRepository.save(tarefa);
    }

}
