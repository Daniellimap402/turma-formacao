package com.basis.campina.xtarefas.domain.elasticsearch;

import com.basis.campina.xtarefas.service.enumeration.StatusEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;

import java.time.LocalDate;

@Getter
@Setter
@Document(indexName = "index-tarefa")
@NoArgsConstructor
public class TarefaDocument extends BaseDocument {

    @MultiField(mainField = @Field(type = FieldType.Text, store = true, analyzer = TRIM_CASE_INSENSITIVE, fielddata = true),
            otherFields = {@InnerField(suffix = SORT, type = FieldType.Text, store = true, analyzer = TRIM_CASE_INSENSITIVE, fielddata = true)})
    private String nome;

    @MultiField(mainField = @Field(type = FieldType.Keyword, store = true),
            otherFields = {@InnerField(suffix = SORT, type = FieldType.Date, store = true, format = DateFormat.custom, pattern = DATE_PATTERN)})
    private String dataConclusao;

    @MultiField(mainField = @Field(type = FieldType.Keyword, store = true),
            otherFields = {@InnerField(suffix = SORT, type = FieldType.Date, store = true, format = DateFormat.custom, pattern = DATE_PATTERN)})
    private String dataInicio;

    @MultiField(mainField = @Field(type = FieldType.Text, store = true, analyzer = TRIM_CASE_INSENSITIVE, fielddata = true),
            otherFields = {@InnerField(suffix = SORT, type = FieldType.Text, store = true, analyzer = TRIM_CASE_INSENSITIVE, fielddata = true)})
    private StatusEnum status;

    public TarefaDocument(Long id, String nome, LocalDate dataConclusao, LocalDate dataInicio, StatusEnum status) {
        this.id = id;
        this.nome = nome;
        this.dataConclusao = converterData(dataConclusao);
        this.dataInicio = converterData(dataInicio);
        this.status = status;
    }
}
