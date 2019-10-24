package com.webapp.storage;

import com.webapp.model.Resume;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10_000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int counter;

    public int size() {
        return counter;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume with uuid " + uuid + " not found");
            return null;
        }
        return storage[index];
    }

    protected abstract int getIndex (String uuid);
}
