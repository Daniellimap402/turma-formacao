package com.basis.campina.xtarefas.service;

import com.basis.campina.xtarefas.repository.TarefaRepository;
import com.basis.campina.xtarefas.service.dto.TarefaDTO;
import com.basis.campina.xtarefas.service.mapper.TarefaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository repository;

    private final TarefaMapper mapper;

    public TarefaDTO salvar(TarefaDTO dto){
        this.repository.save(mapper.toEntity(dto));
        return null;
    }

    public TarefaDTO buscarPorId(Long id){
        return mapper.toDto(this.repository.findById(id).orElseThrow(null));
    }

    public void deletar(Long id){
        this.repository.deleteById(id);
    }
}
