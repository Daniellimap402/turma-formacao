package com.basis.campina.xdocumentos.web.rest;

import com.basis.campina.xdocumentos.service.DocumentoService;
import com.basis.campina.xdocumentos.service.dto.DocumentoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/documentos")
@RequiredArgsConstructor
public class DocumentosResource {

    private final DocumentoService service;

    @PostMapping()
    public ResponseEntity<String> salvar(@RequestBody DocumentoDTO documentoDTO) {
        return ResponseEntity.ok(service.save(documentoDTO));
    }

    @GetMapping("/buscar")
    public ResponseEntity<DocumentoDTO> buscar(@RequestParam("uuId") String uuId) {
        return ResponseEntity.ok(service.getDocument(uuId));
    }

    @DeleteMapping()
    public ResponseEntity<DocumentoDTO> remover(@RequestParam("uuId") String uuId) {
        service.removeDocument(uuId);
        return ResponseEntity.ok().build();
    }

}
