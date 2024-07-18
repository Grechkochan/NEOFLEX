package ru.vasilenko.dictionary.dto.converter;

import ru.vasilenko.dictionary.dto.CreateUpdateDictionaryDto;
import ru.vasilenko.dictionary.dto.DataDto;
import ru.vasilenko.dictionary.dto.DictionaryDto;
import ru.vasilenko.dictionary.model.DataEntity;
import ru.vasilenko.dictionary.model.DictionaryEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DictionaryDtoConverter {

    public static DictionaryEntity convertDtoToEntity(CreateUpdateDictionaryDto dto)
    {
        DictionaryEntity dictionaryEntity = new DictionaryEntity();

        dictionaryEntity.setUuid(UUID.randomUUID().toString());
        dictionaryEntity.setCode(dto.getCode());
        dictionaryEntity.setDescription(dto.getDescription());

        return dictionaryEntity;
    }

    public static DictionaryDto convertEntityToDto(DictionaryEntity dictionaryEntity, List<DataEntity> dataEntities) {
        DictionaryDto dictionaryDto = new DictionaryDto();

        dictionaryDto.setId(dictionaryEntity.getUuid());
        dictionaryDto.setCode(dictionaryEntity.getCode());
        dictionaryDto.setDescription(dictionaryEntity.getDescription());
        dictionaryDto.setDatas(convertDatasToDto(dataEntities));

        return dictionaryDto;
    }

    private static List<DataDto> convertDatasToDto (List<DataEntity> dataEntities){
        List<DataDto> res = new ArrayList<>();

        dataEntities.forEach(element-> {
            DataDto dataDto = new DataDto();

            dataDto.setDictionary_id(element.getDictionary().getUuid());
            dataDto.setCode(element.getCode());
            dataDto.setId(element.getUuid());
            dataDto.setValue(element.getValue());

            res.add(dataDto);
        });

        return res;
    }
}
