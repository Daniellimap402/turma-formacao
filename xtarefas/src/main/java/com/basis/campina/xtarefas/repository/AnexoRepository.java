package com.basis.campina.xtarefas.repository;

import com.basis.campina.xtarefas.domain.Anexo;
import com.basis.campina.xtarefas.domain.Responsavel;
import com.basis.campina.xtarefas.domain.elasticsearch.AnexoDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AnexoRepository extends JpaRepository<Anexo,Long> {

    void deleteByUuId(String uuId);

    @Query(value = "select new com.basis.campina.xtarefas.domain.elasticsearch.AnexoDocument" +
            "(a.id, a.file , a.fileName, a.uuId) from Anexo a where (a.id = :id)")
    AnexoDocument getAnexo(@Param("id") Long id);

}
