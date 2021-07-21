package com.basis.campina.xtarefas.service;

import com.basis.campina.xtarefas.repository.ResponsavelRepository;
import com.basis.campina.xtarefas.service.dto.AnexoDTO;
import com.basis.campina.xtarefas.service.dto.ResponsavelDTO;
import com.basis.campina.xtarefas.service.mapper.ResponsavelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResponsavelService {

    private final ResponsavelRepository repository;

    private final ResponsavelMapper mapper;

    public ResponsavelDTO salvar(ResponsavelDTO dto){
        this.repository.save(mapper.toEntity(dto));
        return null;
    }

    public ResponsavelDTO buscarPorId(Long id){
        return mapper.toDto(this.repository.findById(id).orElseThrow(null));
    }

    public void deletar(Long id){
        this.repository.deleteById(id);
    }

}
