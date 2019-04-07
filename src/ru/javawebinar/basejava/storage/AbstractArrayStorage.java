package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {

    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }


    public void save(Resume element) {
        int index = getIndex(element.getUuid());
        if (index == STORAGE_LIMIT) {
            System.out.println("Storage overflow");
        } else if (index < 0) {
            insertElement(element, index);
            storage[size] = element;
            size++;
        } else {
            System.out.println("Resume already exist");
        }
    }


    public void update(Resume element) {
        int index = getIndex(element.getUuid());
        if (index < 0) {
            System.out.println("Resume not exist");
        } else {
            storage[index] = element;
        }
    }


    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Resume don't find");
        } else {
            fillDeletedElement(index);
            storage[size - 1] = null;
            size--;
        }
    }

    public int size() {
        return size;
    }


    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }


    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Resume not exist");
            return null;

        }
        return storage[index];
    }

    protected abstract int getIndex(String uuid);

    protected abstract void insertElement(Resume element, int index);

    protected abstract void fillDeletedElement(int index);

}


