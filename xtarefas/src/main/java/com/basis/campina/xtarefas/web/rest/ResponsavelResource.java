package com.basis.campina.xtarefas.web.rest;

import com.basis.campina.xtarefas.domain.elasticsearch.ResponsavelDocument;
import com.basis.campina.xtarefas.service.ResponsavelService;
import com.basis.campina.xtarefas.service.dto.DominioFixoDTO;
import com.basis.campina.xtarefas.service.dto.ResponsavelDTO;
import com.basis.campina.xtarefas.service.filter.ResponsavelFilter;
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

import java.util.List;


@RestController
@RequestMapping("/api/responsaveis")
@RequiredArgsConstructor
public class ResponsavelResource {

    private final ResponsavelService service;

    @PostMapping()
    public ResponseEntity<ResponsavelDTO> salvar(@RequestBody ResponsavelDTO dto) {
        this.service.salvar(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponsavelDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        this.service.deletar(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/search")
    public ResponseEntity<Page<ResponsavelDocument>> search(@RequestBody ResponsavelFilter filter, Pageable pageable) {
        Page<ResponsavelDocument> documents = service.search(filter, pageable);
        return ResponseEntity.ok(documents);
    }

    @GetMapping("/dominios-fixos")
    public ResponseEntity<List<DominioFixoDTO>> buscarDominiosFixos() {
        return ResponseEntity.ok(service.buscarDominiosFixos());
    }

}
