package com.basis.campina.xtarefas.web.rest;

import com.basis.campina.xtarefas.service.AnexoService;
import com.basis.campina.xtarefas.service.dto.AnexoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/anexos/")
@RequiredArgsConstructor
public class AnexoResource {

    private final AnexoService service;

    @PostMapping()
    public ResponseEntity<AnexoDTO> salvar(@RequestBody AnexoDTO dto) {
        this.service.salvar(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<AnexoDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.buscarPorId(id));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        this.service.deletar(id);
        return ResponseEntity.ok().build();
    }

}
