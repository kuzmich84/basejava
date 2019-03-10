package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {

    protected static final int STORAGE_LIMIT = 10000;
    public Resume[] storage = new Resume[STORAGE_LIMIT];

    protected int size = 0;

 public void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    public void save(Resume r) {

        int index = getIndex(r.toString());
        if (index == STORAGE_LIMIT) {
            System.out.println("Storage overflow");
        } else if (index == -1) {
            storage[size] = r;
            size++;

        } else {
            System.out.println("Resume already exist");

        }

    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;

        } else {
            System.out.println("Resume don't find");

        }


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


