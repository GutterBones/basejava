package com.webapp.storage;

import com.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < counter; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void addElem(int index, Resume resume) {
        storage[counter] = resume;
    }

    @Override
    protected void shiftDel(int index) {
        storage[index] = storage[counter - 1];
    }
}
