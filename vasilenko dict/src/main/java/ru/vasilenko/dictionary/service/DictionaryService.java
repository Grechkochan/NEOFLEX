package ru.vasilenko.dictionary.service;



import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vasilenko.dictionary.dto.CreateUpdateDictionaryDto;
import ru.vasilenko.dictionary.dto.DictionaryDto;
import ru.vasilenko.dictionary.dto.converter.DictionaryDtoConverter;
import ru.vasilenko.dictionary.exception.DictionaryNotFoundException;
import ru.vasilenko.dictionary.model.DataEntity;
import ru.vasilenko.dictionary.model.DictionaryEntity;
import ru.vasilenko.dictionary.repository.DataRepository;
import ru.vasilenko.dictionary.repository.DictionaryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DictionaryService {

    private final DictionaryRepository dictionaryRepository;

    private final DataRepository dataRepository;

    @Transactional
    public DictionaryDto createDictionary(CreateUpdateDictionaryDto dto) {
        DictionaryEntity dictionaryEntity = DictionaryDtoConverter.convertDtoToEntity(dto);

        dictionaryEntity = dictionaryRepository.save(dictionaryEntity);

        return DictionaryDtoConverter.convertEntityToDto(dictionaryEntity, getDataByDictionary(dictionaryEntity));
    }

    @Transactional(readOnly = true)
    public DictionaryDto getDictionaryDtoById(String uuid){

        DictionaryEntity dictionaryEntity = getDictionaryEntityById(uuid);

        return DictionaryDtoConverter.convertEntityToDto(dictionaryEntity, getDataByDictionary(dictionaryEntity));
    }

    @Transactional(readOnly = true)
    public DictionaryEntity getDictionaryEntityById(String uuid){
        return dictionaryRepository.findById(uuid)
                .orElseThrow(()->new DictionaryNotFoundException("Словарь с id " + uuid + " не найден!"));
    }

    public List<DataEntity> getDataByDictionary (DictionaryEntity dictionaryEntity) {
        return dataRepository.findByDictionary(dictionaryEntity);
    }
}
