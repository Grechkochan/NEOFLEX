package ru.vasilenko.dictionary.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataEntity {
    @Id
    @Column(name = "id")
    private String uuid;

    @ManyToOne
    @JoinColumn(name = "dictionary_id", referencedColumnName = "id")
    private DictionaryEntity dictionary;

    @Column(name = "code")
    private String code;

    @Column(name = "value")
    private String value;
}
