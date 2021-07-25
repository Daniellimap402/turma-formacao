package com.basis.campina.xtarefas.domain.elasticsearch;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;
import org.springframework.data.elasticsearch.annotations.Setting;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Setting(settingPath = "/config/elastic/config.json")
public class BaseDocument implements Serializable {

    protected static final String TRIM_CASE_INSENSITIVE = "trim_case_insensitive";
    protected static final String SORT = "sort";
    protected static final String DATE_PATTERN = "dd/MM/yyyy";


    @MultiField(mainField = @Field(type = FieldType.Long, store = true), otherFields = {@InnerField(suffix = SORT, type = FieldType.Long, store = true)})
    protected Long id;

    protected String converterData(LocalDate date) {
        return date != null ?
                date.format(DateTimeFormatter.ofPattern(DATE_PATTERN)) : null;
    }

}
