package com.basis.campina.xtarefas.resource;

import com.basis.campina.xtarefas.domain.Anexo;
import com.basis.campina.xtarefas.domain.Responsavel;
import com.basis.campina.xtarefas.service.dto.AnexoDTO;
import com.basis.campina.xtarefas.service.dto.ResponsavelDTO;
import com.basis.campina.xtarefas.test.IntTestComum;
import com.basis.campina.xtarefas.test.build.AnexoBuilder;
import com.basis.campina.xtarefas.util.TestUtil;
import com.basis.campina.xtarefas.web.rest.AnexoResource;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@Transactional
@ExtendWith(SpringExtension.class)
@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AnexoResourceIT extends IntTestComum {

    private final static String URL = "/api/anexos/";
    private final static String ID = URL + "{id}";

    @Autowired
    private AnexoBuilder builder;

    @Test
    @DisplayName("Criar anexo com sucesso")
    public void criarAnexoComSucesso() throws Exception {
        AnexoDTO anexoDTO = builder.construirDto();

        getMockMvc().perform(post(URL)
                        .contentType(TestUtil.APPLICATION_JSON_UTF8)
                        .content(TestUtil.convertObjectToJsonBytes(anexoDTO)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Buscar anexo com sucesso")
    public void buscarAnexoComSucesso() throws Exception {
        Anexo anexo = builder.construir();

        getMockMvc().perform(get(ID, anexo.getId())
                        .contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Remover anexo com sucesso")
    public void removerAnexoComSucesso() throws Exception {
        Anexo anexo = builder.construir();

        getMockMvc().perform(delete(URL)
                        .queryParam("uuId", anexo.getUuId())
                        .contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Buscar anexo por uuId com sucesso")
    public void buscarAnexoPorUuIdComSucesso() throws Exception {
        Anexo anexo = builder.construir();

        getMockMvc().perform(get(URL)
                        .queryParam("uuId", anexo.getUuId())
                        .contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }

}
