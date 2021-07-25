package com.basis.campina.xtarefas.service.elastic;

import com.basis.campina.xtarefas.domain.elasticsearch.AnexoDocument;
import com.basis.campina.xtarefas.domain.elasticsearch.ResponsavelDocument;
import com.basis.campina.xtarefas.repository.AnexoRepository;
import com.basis.campina.xtarefas.repository.ResponsavelRepository;
import com.basis.campina.xtarefas.repository.elastic.AnexoSearchRepository;
import com.basis.campina.xtarefas.repository.elastic.ResponsavelSearchRepository;
import com.basis.campina.xtarefas.service.event.AnexoEvent;
import com.basis.campina.xtarefas.service.event.ResponsavelEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AnexoElasticsearchService {

    private final AnexoRepository repository;
    private final AnexoSearchRepository searchRepository;

    @TransactionalEventListener(fallbackExecution = true)
    public void reindex(AnexoEvent event){
        AnexoDocument document = repository.getAnexo(event.getId());
        searchRepository.save(document);
    }

}
