package com.basis.campina.xtarefas.repository;

import com.basis.campina.xtarefas.domain.Anexo;
import com.basis.campina.xtarefas.domain.Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnexoRepository extends JpaRepository<Anexo,Long> {
}
