package ru.vasilenko.dictionary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vasilenko.dictionary.model.DataEntity;
import ru.vasilenko.dictionary.model.DictionaryEntity;

import java.util.List;

public interface DataRepository extends JpaRepository<DataEntity, String> {

    List<DataEntity> findByDictionary(DictionaryEntity dictionaryEntity);
}
