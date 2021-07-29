package com.basis.campina.xtarefas.resource;

import com.basis.campina.xtarefas.config.containers.ContainersFactory;
import com.basis.campina.xtarefas.domain.Responsavel;
import com.basis.campina.xtarefas.service.dto.ResponsavelDTO;
import com.basis.campina.xtarefas.service.elastic.ElasticSearchService;
import com.basis.campina.xtarefas.service.event.ResponsavelEvent;
import com.basis.campina.xtarefas.service.filter.ResponsavelFilter;
import com.basis.campina.xtarefas.test.IntTestComum;
import com.basis.campina.xtarefas.test.build.ResponsavelBuilder;
import com.basis.campina.xtarefas.util.TestUtil;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.junit.jupiter.Container;
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
public class ResponsavelResourceIT extends IntTestComum {

    private final static String URL = "/api/responsaveis/";
    private final static String ID = URL + "{id}";
    private final static String SEARCH_RESPONSAVEIS = URL+"search";

    @Autowired
    private ResponsavelBuilder builder;

    @Autowired
    private ElasticSearchService searchService;

    @Container
    private static ContainersFactory containersFactory = ContainersFactory.getInstance();

    @Test
    @DisplayName("Criar responsavel com sucesso")
    public void criarCursoComSucesso() throws Exception {
        ResponsavelDTO responsavel = builder.construirDto();

        getMockMvc().perform(post(URL)
                        .contentType(TestUtil.APPLICATION_JSON_UTF8)
                        .content(TestUtil.convertObjectToJsonBytes(responsavel)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Buscar responsavel com sucesso")
    public void buscarCursoComSucesso() throws Exception {
        Responsavel responsavel = builder.construir();

        getMockMvc().perform(get(ID, responsavel.getId())
                        .contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Buscar responsavel com sucesso")
    public void deletarCursoComSucesso() throws Exception {
        Responsavel responsavel = builder.construir();

        getMockMvc().perform(delete(ID, responsavel.getId())
                        .contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }

    @Test
    @Transactional
    @DisplayName("Listar Responsável com sucesso")
    public void listarResponsaveis() throws Exception {
        ResponsavelDTO responsavelDTO= this.builder.construirDto();

        this.searchService.reindex();
        new ResponsavelEvent(responsavelDTO.getId());

        ResponsavelFilter filtro = new ResponsavelFilter();
        filtro.setQuery(responsavelDTO.getNome());

        getMockMvc().perform(post(SEARCH_RESPONSAVEIS).contentType(TestUtil.APPLICATION_JSON_UTF8)
                        .content(TestUtil.convertObjectToJsonBytes(filtro)))
                .andExpect(status().isOk());
    }

}
