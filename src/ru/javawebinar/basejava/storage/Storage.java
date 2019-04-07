package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;


public interface Storage {

    void clear();

    void save(Resume element);

    void update(Resume element);

    Resume get(String uuid);

    void delete(String uuid);

    Resume[] getAll();

    int size();


}

