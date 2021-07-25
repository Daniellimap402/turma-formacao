package com.basis.campina.xtarefas.domain.elasticsearch;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;

@Getter
@Setter
@Document(indexName = "index-anexos")
@NoArgsConstructor
public class AnexoDocument extends BaseDocument{

    @MultiField(mainField = @Field(type = FieldType.Text, store = true, analyzer = TRIM_CASE_INSENSITIVE, fielddata = true),
            otherFields = {@InnerField(suffix = SORT, type = FieldType.Text, store = true, analyzer = TRIM_CASE_INSENSITIVE, fielddata = true)})
    private String  file;

    @MultiField(mainField = @Field(type = FieldType.Text, store = true, analyzer = TRIM_CASE_INSENSITIVE, fielddata = true),
            otherFields = {@InnerField(suffix = SORT, type = FieldType.Text, store = true, analyzer = TRIM_CASE_INSENSITIVE, fielddata = true)})
    private String fileName;

    @MultiField(mainField = @Field(type = FieldType.Text, store = true, analyzer = TRIM_CASE_INSENSITIVE, fielddata = true),
            otherFields = {@InnerField(suffix = SORT, type = FieldType.Text, store = true, analyzer = TRIM_CASE_INSENSITIVE, fielddata = true)})
    private String uuId;

    public AnexoDocument(Long id, String file, String fileName, String uuId) {
        this.id = id;
        this.file = file;
        this.fileName = fileName;
        this.uuId = uuId;
    }
}
