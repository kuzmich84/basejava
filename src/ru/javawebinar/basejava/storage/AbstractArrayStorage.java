package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {

    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    protected int size = 0;

 public void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    public int size() {

        return size;
    }

    public Resume[] getAll() {

        return Arrays.copyOfRange(storage,0, size);
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            return storage[index];
        }
        System.out.println("Resume not exist");
        return null;
    }

    protected abstract int getIndex(String uuid);

}


