package com.basis.campina.xtarefas.repository.elastic;

import com.basis.campina.xtarefas.domain.elasticsearch.AnexoDocument;
import com.basis.campina.xtarefas.domain.elasticsearch.ResponsavelDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnexoSearchRepository extends ElasticsearchRepository<AnexoDocument, Long> {
}
