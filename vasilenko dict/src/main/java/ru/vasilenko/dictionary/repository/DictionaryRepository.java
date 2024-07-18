package ru.vasilenko.dictionary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vasilenko.dictionary.model.DictionaryEntity;

public interface DictionaryRepository extends JpaRepository<DictionaryEntity, String> {
}
