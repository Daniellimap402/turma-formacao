package com.basis.campina.xtarefas.repository;

import com.basis.campina.xtarefas.domain.Anexo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnexoRepository extends JpaRepository<Anexo,Long> {

    void deleteByUuId(String uuId);

    @Query(value = "select a.fileName from Anexo a where a.tarefa.id = :id")
    List<String> getNomeAnexosByTarefaId(@Param("id") Long id);

}
