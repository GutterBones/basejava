package com.webapp.storage;

import com.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, counter, searchKey);
    }

    @Override
    protected void addElem(int index, Resume resume) {
        int addIndex = -index - 1;
        System.arraycopy(storage, addIndex, storage, addIndex + 1, counter - addIndex);
        storage[addIndex] = resume;
    }

    @Override
    protected void shiftDel(int index) {
        System.arraycopy(storage, index + 1, storage, index, counter - 1 - index);
    }
}
