package com.basis.campina.xtarefas.service;

import com.basis.campina.xtarefas.repository.AnexoRepository;
import com.basis.campina.xtarefas.service.dto.AnexoDTO;
import com.basis.campina.xtarefas.service.feign.DocumentClient;
import com.basis.campina.xtarefas.service.mapper.AnexoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AnexoService {

    private final AnexoRepository repository;

    private final AnexoMapper mapper;

    private final DocumentClient client;

    public AnexoDTO salvar(AnexoDTO dto) {

        dto.setUuId(UUID.randomUUID().toString());
        this.repository.save(mapper.toEntity(dto));
        client.salvar(dto);

        return null;
    }

    public AnexoDTO buscarPorId(Long id) {
        return this.mapper.toDto(this.repository.findById(id).orElseThrow(null));
    }

    public void deletar(Long id) {
        this.repository.deleteById(id);
    }
}
