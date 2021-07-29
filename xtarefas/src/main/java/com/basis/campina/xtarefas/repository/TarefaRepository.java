package com.basis.campina.xtarefas.repository;

import com.basis.campina.xtarefas.domain.Tarefa;
import com.basis.campina.xtarefas.domain.elasticsearch.ResponsavelDocument;
import com.basis.campina.xtarefas.domain.elasticsearch.TarefaDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TarefaRepository extends JpaRepository<Tarefa,Long> {

    @Query(value = "select new com.basis.campina.xtarefas.domain.elasticsearch.TarefaDocument" +
            "(t.id, t.nome , t.dataConclusao, t.dataInicio, t.status, t.responsavel.nome) from Tarefa t where (t.id = :id)")
    TarefaDocument getTarefa(@Param("id") Long id);

}
