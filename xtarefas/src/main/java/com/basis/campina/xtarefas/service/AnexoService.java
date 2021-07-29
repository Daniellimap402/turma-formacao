package com.basis.campina.xtarefas.service;

import com.basis.campina.xtarefas.domain.Anexo;
import com.basis.campina.xtarefas.repository.AnexoRepository;
import com.basis.campina.xtarefas.service.dto.AnexoDTO;
import com.basis.campina.xtarefas.service.feign.DocumentClient;
import com.basis.campina.xtarefas.service.mapper.AnexoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class AnexoService {

    private final AnexoRepository repository;

    private final AnexoMapper mapper;

    private final DocumentClient client;

    public AnexoDTO salvar(AnexoDTO dto) {
        dto.setUuId(UUID.randomUUID().toString());
        Anexo anexo = this.repository.save(mapper.toEntity(dto));
        client.salvar(dto);
        return mapper.toDto(anexo);
    }

    public AnexoDTO buscarPorId(Long id) {
        return this.mapper.toDto(this.repository.findById(id).orElseThrow(null));
    }

    public ResponseEntity<AnexoDTO> buscar(String uuId){
        return client.buscar(uuId);
    }

    public void deletar(String uuId) {
        this.repository.deleteByUuId(uuId);
        client.remover(uuId);
    }

    public List<String> getNomeAnexosByTarefaId(Long id) {
        return repository.getNomeAnexosByTarefaId(id);
    }
}
