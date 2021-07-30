package com.basis.campina.xtarefas.config.feign;

import com.basis.campina.xtarefas.service.feign.DocumentClient;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import javax.annotation.PostConstruct;

@Configuration
public class FeignMockConfiguracao {

    @MockBean
    private DocumentClient feignClient;

    @PostConstruct
    public void mock(){
        Mockito.when(feignClient.salvar(Mockito.any())).thenReturn(ResponseEntity.ok().build());
    }

}
