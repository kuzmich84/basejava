package ru.javawebinar.basejava.storage;

import java.util.Arrays;
import ru.javawebinar.basejava.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

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

    public void update(Resume r) {
        int index = getIndex(r.toString());
        if (index != -1) {
            storage[index] = r;

        } else {
            System.out.println("Resume not exist");
        }

    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            return storage[index];


        }
        System.out.println("Resume not exist");
        return null;
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

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {

        return Arrays.copyOfRange(storage,0, size);
    }



    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;

    }

}

