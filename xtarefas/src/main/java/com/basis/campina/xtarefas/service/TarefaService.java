package com.basis.campina.xtarefas.service;

import com.basis.campina.xtarefas.domain.Tarefa;
import com.basis.campina.xtarefas.repository.TarefaRepository;
import com.basis.campina.xtarefas.service.dto.TarefaDTO;
import com.basis.campina.xtarefas.service.event.AnexoEvent;
import com.basis.campina.xtarefas.service.event.TarefaEvent;
import com.basis.campina.xtarefas.service.feign.DocumentClient;
import com.basis.campina.xtarefas.service.mapper.TarefaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class TarefaService {

    private final TarefaRepository repository;

    private final TarefaMapper mapper;

    private final DocumentClient client;

    private final ApplicationEventPublisher eventPublisher;

    public TarefaDTO salvar(TarefaDTO dto){
        setUuIdAnexos(dto);
        Tarefa tarefa = this.repository.save(mapper.toEntity(dto));
        publishAnexoEvent(tarefa);
        this.eventPublisher.publishEvent(new TarefaEvent(tarefa.getId()));
        return mapper.toDto(tarefa);
    }

    private void publishAnexoEvent(Tarefa tarefa) {
        tarefa.getAnexos().stream().forEach(anexo -> {
            this.eventPublisher.publishEvent(new AnexoEvent(anexo.getId()));
        });
    }

    private void setUuIdAnexos(TarefaDTO dto) {
        dto.getAnexos().stream().forEach(anexoDTO -> {
            anexoDTO.setUuId(UUID.randomUUID().toString());
            client.salvar(anexoDTO);
        });
    }

    public TarefaDTO buscarPorId(Long id){
        return mapper.toDto(this.repository.findById(id).orElseThrow(null));
    }

    public void deletar(Long id){
        this.repository.deleteById(id);
    }
}
