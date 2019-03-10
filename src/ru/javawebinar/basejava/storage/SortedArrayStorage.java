package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {


    protected  void insertElement(Resumer r, int index) {
        index = -(index) - 1;
        System.arraycopy(storage, index, storage, index + 1, k - index);
        storage[index] = newElement;
        }






    @Override
    public void save(Resume r) {
        int index = getIndex(r.toString());
        if (index == STORAGE_LIMIT) {
            System.out.println("Storage overflow");
        } else if (index == -1) {
            storage[size] = r;
            size++;
            sort(storage);

        } else {
            System.out.println("Resume already exist");

        }

    }

    @Override
    public void update(Resume r) {
        int index = getIndex(r.toString());
        if (index != -1) {
            storage[index] = r;
            sort(storage);

        } else {
            System.out.println("Resume not exist");
        }
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
            sort(storage);

        } else {
            System.out.println("Resume don't find");

        }

    }


    @Override
    protected  int getIndex(String uuid) {
        Resume searchKey=new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(sort(storage),0,size,searchKey);
    }
}
