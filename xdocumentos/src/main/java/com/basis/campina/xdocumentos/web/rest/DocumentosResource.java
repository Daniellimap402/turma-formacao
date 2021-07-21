package com.basis.campina.xdocumentos.web.rest;

import com.basis.campina.xdocumentos.service.DocumentoService;
import com.basis.campina.xdocumentos.service.dto.DocumentoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/documentos")
@RequiredArgsConstructor
public class DocumentosResource {

    private final DocumentoService service;

    @PostMapping()
    public ResponseEntity<String> save(@RequestBody DocumentoDTO documentoDTO) {
        return ResponseEntity.ok(service.save(documentoDTO));
    }
}
