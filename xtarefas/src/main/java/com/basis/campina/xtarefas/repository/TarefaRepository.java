package com.basis.campina.xtarefas.repository;

import com.basis.campina.xtarefas.domain.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa,Long> {
}
