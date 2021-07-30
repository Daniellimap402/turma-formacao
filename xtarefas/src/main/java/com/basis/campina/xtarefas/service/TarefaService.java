package com.basis.campina.xtarefas.service;

import com.basis.campina.xtarefas.domain.Tarefa;
import com.basis.campina.xtarefas.domain.elasticsearch.TarefaDocument;
import com.basis.campina.xtarefas.repository.TarefaRepository;
import com.basis.campina.xtarefas.repository.elastic.TarefaSearchRepository;
import com.basis.campina.xtarefas.service.dto.TarefaDTO;
import com.basis.campina.xtarefas.service.elastic.ElasticSearchService;
import com.basis.campina.xtarefas.service.event.TarefaEvent;
import com.basis.campina.xtarefas.service.feign.DocumentClient;
import com.basis.campina.xtarefas.service.filter.TarefaFilter;
import com.basis.campina.xtarefas.service.mapper.TarefaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class TarefaService {

    private final TarefaRepository repository;

    private final TarefaMapper mapper;

    private final DocumentClient client;

    private final ApplicationEventPublisher eventPublisher;

    private final ElasticSearchService elasticSearchService;

    private final TarefaSearchRepository searchRepository;

    public TarefaDTO salvar(TarefaDTO dto){
        setUuIdAnexos(dto);
        Tarefa tarefa = this.repository.save(mapper.toEntity(dto));
        this.eventPublisher.publishEvent(new TarefaEvent(tarefa.getId()));
        return mapper.toDto(tarefa);
    }

    private void setUuIdAnexos(TarefaDTO dto) {
        dto.getAnexos().stream().forEach(anexoDTO -> {
            anexoDTO.setUuId(UUID.randomUUID().toString());
            client.salvar(anexoDTO);
        });
    }

    public TarefaDTO buscarPorId(Long id){
        return mapper.toDto(this.repository.findById(id).orElseThrow(null));
    }

    public void deletar(Long id){
        this.repository.deleteById(id);
        this.searchRepository.deleteById(id);
    }

    public Page<TarefaDocument> search(TarefaFilter filter, Pageable pageable) {
        return searchRepository.search(filter.getFilter(), pageable);
    }
}
