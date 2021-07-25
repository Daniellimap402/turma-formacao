package com.basis.campina.xtarefas.service.feign;

import com.basis.campina.xtarefas.service.dto.AnexoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "xdocumentos", url = "${application.feign.url-documents}")
public interface DocumentClient {

    @PostMapping("/api/documentos")
    ResponseEntity<String> salvar(AnexoDTO anexoDTO);

    @RequestMapping(method = RequestMethod.GET, value = "/api/documentos/buscar")
    ResponseEntity<AnexoDTO> buscar(@RequestParam("uuId") String uuId);

    @RequestMapping(method = RequestMethod.DELETE, value = "/api/documentos")
    ResponseEntity<AnexoDTO> remover(@RequestParam("uuId") String uuId);
}
