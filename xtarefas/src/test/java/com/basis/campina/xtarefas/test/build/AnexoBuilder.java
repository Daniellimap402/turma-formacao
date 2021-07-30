package com.basis.campina.xtarefas.test.build;

import com.basis.campina.xtarefas.domain.Anexo;
import com.basis.campina.xtarefas.service.AnexoService;
import com.basis.campina.xtarefas.service.dto.AnexoDTO;
import com.basis.campina.xtarefas.service.dto.TarefaDTO;
import com.basis.campina.xtarefas.service.mapper.AnexoMapper;
import com.basis.campina.xtarefas.util.ConstantsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;

@Component
public class AnexoBuilder extends ConstrutorEntidade<Anexo> {

    @Autowired
    private AnexoMapper mapper;

    @Autowired
    private AnexoService service;

    @Override
    public Anexo construirEntidade() throws ParseException {
        Anexo anexo = new Anexo();
        anexo.setFile(ConstantsUtil.TEXTO_PADRAO);
        anexo.setFileName(ConstantsUtil.TEXTO_PADRAO);
        return anexo;
    }

    public AnexoDTO construirDto() throws ParseException {
        return mapper.toDto(construirEntidade());
    }

    @Override
    protected Anexo persistir(Anexo entidade) {
        return this.mapper.toEntity(service.salvar(this.mapper.toDto(entidade)));
    }

    @Override
    protected Collection<Anexo> obterTodos() {
        return null;
    }

    @Override
    protected Anexo obterPorId(Long id) {
        return null;
    }
}
