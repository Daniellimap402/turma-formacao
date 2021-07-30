package com.basis.campina.xtarefas.web.rest;

import com.basis.campina.xtarefas.domain.elasticsearch.TarefaDocument;
import com.basis.campina.xtarefas.service.TarefaService;
import com.basis.campina.xtarefas.service.dto.TarefaDTO;
import com.basis.campina.xtarefas.service.filter.TarefaFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tarefas")
@RequiredArgsConstructor
public class TarefaResource {

    private final TarefaService service;

    @PostMapping()
    public ResponseEntity<TarefaDTO> salvar(@RequestBody TarefaDTO dto) {
        this.service.salvar(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        this.service.deletar(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/search")
    public ResponseEntity<Page<TarefaDocument>> search(@RequestBody TarefaFilter filter, Pageable pageable) {
        Page<TarefaDocument> documents = service.search(filter, pageable);
        return ResponseEntity.ok(documents);
    }

}
