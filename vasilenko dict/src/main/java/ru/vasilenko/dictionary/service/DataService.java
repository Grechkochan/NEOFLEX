package ru.vasilenko.dictionary.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vasilenko.dictionary.dto.CreateUpdateDataDto;
import ru.vasilenko.dictionary.dto.DataDto;
import ru.vasilenko.dictionary.exception.DataNotFoundException;
import ru.vasilenko.dictionary.exception.DictionaryNotFoundException;
import ru.vasilenko.dictionary.model.DataEntity;
import ru.vasilenko.dictionary.repository.DataRepository;
import ru.vasilenko.dictionary.repository.DictionaryRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DataService {

    private final DataRepository dataRepository;

    private final DictionaryService dictionaryService;

    @Transactional
    public DataDto save(CreateUpdateDataDto createUpdateDataDto){
        var dictionary = dictionaryService.getDictionaryEntityById(createUpdateDataDto.getDictionaryId());

        var entity = new DataEntity(
                UUID.randomUUID().toString(),
                dictionary,
                createUpdateDataDto.getCode(),
                createUpdateDataDto.getValue()
        );
        var savedEntity = dataRepository.save(entity);
        dictionaryService.save(dictionary);
        return new DataDto(
                savedEntity.getUuid(),
                savedEntity.getDictionary().getUuid(),
                savedEntity.getCode(),
                savedEntity.getValue()
              
        );
    }

    public DataDto getById(String id) {
        var entity = dataRepository.findById(id)
                .orElseThrow(()->new DataNotFoundException("Данные с id " + id + " не найдены!"));
        return new DataDto(
                entity.getUuid(),
                entity.getDictionary().getUuid(),
                entity.getCode(),
                entity.getValue()
        );
    }
}
