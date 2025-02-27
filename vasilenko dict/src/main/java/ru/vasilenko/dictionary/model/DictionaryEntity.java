package ru.vasilenko.dictionary.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Entity
@Table(name = "dictionary")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DictionaryEntity {
    @Id
    @Column(name = "id")
    private UUID uuid;

    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;

}
