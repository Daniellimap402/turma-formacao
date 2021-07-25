package com.basis.campina.xtarefas.service;

import com.basis.campina.xtarefas.domain.Responsavel;
import com.basis.campina.xtarefas.domain.elasticsearch.ResponsavelDocument;
import com.basis.campina.xtarefas.repository.ResponsavelRepository;
import com.basis.campina.xtarefas.repository.elastic.ResponsavelSearchRepository;
import com.basis.campina.xtarefas.service.dto.ResponsavelDTO;
import com.basis.campina.xtarefas.service.event.ResponsavelEvent;
import com.basis.campina.xtarefas.service.filter.ResponsavelFilter;
import com.basis.campina.xtarefas.service.mapper.ResponsavelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ResponsavelService {

    private final ResponsavelRepository repository;

    private final ApplicationEventPublisher eventPublisher;

    private final ResponsavelMapper mapper;

    private final ResponsavelSearchRepository searchRepository;

    public ResponsavelDTO salvar(ResponsavelDTO dto){
        Responsavel responsavel = this.repository.save(mapper.toEntity(dto));
        eventPublisher.publishEvent(new ResponsavelEvent(responsavel.getId()));
        return null;
    }

    public ResponsavelDTO buscarPorId(Long id){
        return mapper.toDto(this.repository.findById(id).orElseThrow(null));
    }

    public void deletar(Long id){
        this.repository.deleteById(id);
    }

    public Page<ResponsavelDocument> search(ResponsavelFilter filter, Pageable pageable){
        return searchRepository.search(filter.getFilter(), pageable);
    }

}
