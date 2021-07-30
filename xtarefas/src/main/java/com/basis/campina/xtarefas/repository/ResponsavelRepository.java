package com.basis.campina.xtarefas.repository;

import com.basis.campina.xtarefas.domain.Responsavel;
import com.basis.campina.xtarefas.domain.elasticsearch.ResponsavelDocument;
import com.basis.campina.xtarefas.repository.elastic.Reindexer;
import com.basis.campina.xtarefas.service.dto.DominioFixoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel,Long>, Reindexer {

    @Query("SELECT NEW  com.basis.campina.xtarefas.domain.elasticsearch.ResponsavelDocument(r.id, r.nome, r.email, r.dataNascimento)"
            + " from Responsavel r order by r.id")
    Page<ResponsavelDocument> reindexPage(Pageable pageable);

    @Query(value = "select new com.basis.campina.xtarefas.domain.elasticsearch.ResponsavelDocument" +
            "(r.id, r.nome , r.email, r.dataNascimento) from Responsavel r where (r.id = :id)")
    ResponsavelDocument getDocument(@Param("id") Long id);

    @Override
    default String getEntity() {
        return "responsaveis";
    }

    @Query(value = "select new com.basis.campina.xtarefas.service.dto.DominioFixoDTO(r.id, r.email)" +
            " from Responsavel r ")
    List<DominioFixoDTO> buscarDominiosFixos();
}
