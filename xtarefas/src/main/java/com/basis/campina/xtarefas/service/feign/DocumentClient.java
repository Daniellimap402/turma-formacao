package com.basis.campina.xtarefas.service.feign;

import com.basis.campina.xtarefas.service.dto.AnexoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "xdocumentos", url = "${application.feign.url-documents}")
public interface DocumentClient {

    @PostMapping("/api/documentos")
    ResponseEntity<String> salvar(AnexoDTO anexoDTO);
}
