package ru.vasilenko.dictionary.exception;

public class DictionaryNotFoundException extends RuntimeException {

    public DictionaryNotFoundException(String message)
    {
        super(message);
    }
}
