package com.basis.campina.xtarefas.resource;

import com.basis.campina.xtarefas.config.containers.ContainersFactory;
import com.basis.campina.xtarefas.domain.Tarefa;
import com.basis.campina.xtarefas.service.dto.TarefaDTO;
import com.basis.campina.xtarefas.service.elastic.ElasticSearchService;
import com.basis.campina.xtarefas.service.event.TarefaEvent;
import com.basis.campina.xtarefas.service.filter.TarefaFilter;
import com.basis.campina.xtarefas.test.IntTestComum;
import com.basis.campina.xtarefas.test.build.TarefaBuilder;
import com.basis.campina.xtarefas.util.TestUtil;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TarefaResourceIT extends IntTestComum {

    private final static String URL = "/api/tarefas/";
    private final static String ID = URL + "{id}";
    private final static String SEARCH_TAREFAS = URL+"search";

    @Autowired
    private TarefaBuilder builder;

    @Container
    private static ContainersFactory containersFactory = ContainersFactory.getInstance();

    @Autowired
    private ElasticSearchService searchService;

    @Test
    @DisplayName("Criar tarefa com sucesso")
    public void criarTarefaComSucesso() throws Exception {
        TarefaDTO tarefa = builder.construirDto();

        getMockMvc().perform(post(URL)
                        .contentType(TestUtil.APPLICATION_JSON_UTF8)
                        .content(TestUtil.convertObjectToJsonBytes(tarefa)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Buscar Tarefa com sucesso")
    public void buscarTarefaComSucesso() throws Exception {
        Tarefa tarefa = builder.construir();

        getMockMvc().perform(get(ID, tarefa.getId())
                        .contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Remover tarefa com sucesso")
    public void removerTarefaComSucesso() throws Exception {
        Tarefa tarefa = builder.construir();

        getMockMvc().perform(delete(ID, tarefa.getId())
                        .contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }

    @Test
    @Transactional
    @DisplayName("Listar Tarefa com sucesso")
    public void listarTarefas() throws Exception {
        this.searchService.reindex();
        Tarefa tarefa= this.builder.construir();

        new TarefaEvent(tarefa.getId());

        TarefaFilter filtro = new TarefaFilter();
        filtro.setQuery(tarefa.getNome());

        getMockMvc().perform(post(SEARCH_TAREFAS).contentType(TestUtil.APPLICATION_JSON_UTF8)
                        .content(TestUtil.convertObjectToJsonBytes(filtro)))
                .andExpect(status().isOk());
    }

}
