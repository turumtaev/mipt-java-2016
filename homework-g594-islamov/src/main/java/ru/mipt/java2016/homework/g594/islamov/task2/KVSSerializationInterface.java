package ru.mipt.java2016.homework.g594.islamov.task2;

/**
 * Created by Iskander Islamov on 30.10.2016.
 */

public interface KVSSerializationInterface<K> {

    String serialize(K object);

    K deserialize(String object) throws BadStorageException;
}
