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
        if (index > 0) {
            storage[index] = element;
        } else {
            System.out.println("Resume not exist");
        }
    }


    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index > 0) {
            fillDeletedElement(index);
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("Resume don't find");
        }
    }

    protected abstract void insertElement(Resume r, int index);

    protected abstract void fillDeletedElement(int index);

    public int size() {
        return size;
    }


    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
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


