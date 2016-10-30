package ru.mipt.java2016.homework.base.task2;

import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;

/**
 * Перзистентное хранилище ключ-значение.
 *
 * Хранилище не обязано сразу же после выполнения запроса изменять состояние на диске, т.е. в процессе работы допустимо
 * расхождение консистентности. Но после выполнения {@link #close()} хранилище должно перейти в консистентное состояние,
 * то есть, на диске должны остаться актуальные данные.
 *
 * @author Fedor S. Lavrentyev
 * @since 04.10.16
 */
public interface KeyValueStorage<K, V> extends Closeable {
    /**
     * Возвращает значение для данного ключа, если оно есть в хранилище.
     * Иначе возвращает null.
     */
    V read(K key);

    /**
     * Возвращает true, если данный ключ есть в хранилище
     */
    boolean exists(K key);

    /**
     * Записывает в хранилище пару ключ-значение.
     */
    void write(K key, V value);

    /**
     * Удаляет пару ключ-значение из хранилища.
     */
    void delete(K key);

    /**
     * Читает все ключи в хранилище.
     * <p>
     * Итератор должен бросать {@link java.util.ConcurrentModificationException},
     * если данные в хранилище были изменены в процессе итерирования.
     */
    Iterator<K> readKeys();

    /**
     * Возвращает число ключей, которые сейчас в хранилище.
     */
    int size() throws Exception;
}
