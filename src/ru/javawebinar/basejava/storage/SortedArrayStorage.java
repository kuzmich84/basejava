package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insertElement(Resume r, int index) {
      //https://juja.com.ua/java/algorithms/sorting-optimizing/

       int insertIndex = -(index) - 1;
        System.arraycopy(storage, insertIndex, storage, insertIndex + 1, size - insertIndex);
        storage[insertIndex] = r;
           }



    @Override
    protected void fillDeletedElement(int index) {
        int numberMoved = -(index) - 1;
        if(numberMoved>0) {
            System.arraycopy(storage, index+1, storage, index, numberMoved );

        }
    }

    @Override
    protected  int getIndex(String uuid) {
        Resume searchKey=new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage,0,size,searchKey);
    }
}
