package com.basis.campina.xtarefas.test.build;

import com.basis.campina.xtarefas.domain.Responsavel;
import com.basis.campina.xtarefas.service.ResponsavelService;
import com.basis.campina.xtarefas.service.dto.ResponsavelDTO;
import com.basis.campina.xtarefas.service.mapper.ResponsavelMapper;
import com.basis.campina.xtarefas.util.ConstantsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collection;

@Component
public class ResponsavelBuilder extends ConstrutorEntidade<Responsavel> {

    @Autowired
    private ResponsavelService service;

    @Autowired
    private ResponsavelMapper mapper;

    @Override
    public Responsavel construirEntidade() {
        Responsavel responsavel = new Responsavel();
        responsavel.setNome(ConstantsUtil.TEXTO_PADRAO);
        responsavel.setEmail(ConstantsUtil.TEXTO_PADRAO);
        responsavel.setDataNascimento(LocalDate.now().minusYears(18));
        return responsavel;
    }

    public ResponsavelDTO construirDto(){
        return mapper.toDto(construirEntidade());
    }

    @Override
    public Responsavel persistir(Responsavel entidade) {
        return mapper.toEntity(service.salvar(mapper.toDto(entidade)));
    }

    @Override
    protected Collection<Responsavel> obterTodos() {
        return null;
    }

    @Override
    protected Responsavel obterPorId(Long id) {
        return null;
    }
}
