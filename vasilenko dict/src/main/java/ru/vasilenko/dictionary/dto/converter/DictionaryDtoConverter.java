package ru.vasilenko.dictionary.dto.converter;

import org.springframework.stereotype.Component;
import ru.vasilenko.dictionary.dto.CreateUpdateDictionaryDto;
import ru.vasilenko.dictionary.dto.DataDto;
import ru.vasilenko.dictionary.dto.DictionaryDto;
import ru.vasilenko.dictionary.model.DataEntity;
import ru.vasilenko.dictionary.model.DictionaryEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Component
public class DictionaryDtoConverter {

    public static DictionaryEntity convertDtoToEntity(CreateUpdateDictionaryDto dto)
    {
        DictionaryEntity dictionaryEntity = new DictionaryEntity();

        dictionaryEntity.setUuid(UUID.randomUUID());
        dictionaryEntity.setCode(dto.getCode());
        dictionaryEntity.setDescription(dto.getDescription());

        return dictionaryEntity;
    }

    public static DictionaryDto convertEntityToDto(DictionaryEntity dictionaryEntity, List<DataEntity> dataEntities) {
        DictionaryDto dictionaryDto = new DictionaryDto();

        dictionaryDto.setId(dictionaryEntity.getUuid());
        dictionaryDto.setCode(dictionaryEntity.getCode());
        dictionaryDto.setDescription(dictionaryEntity.getDescription());

        return dictionaryDto;
    }

}
