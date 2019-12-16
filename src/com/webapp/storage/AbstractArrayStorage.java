package com.webapp.storage;

import com.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10_000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int counter;

    public void clear() {
        Arrays.fill(storage, 0, counter, null);
        counter = 0;
    }

    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            System.out.println("Resume with uuid " + resume.getUuid() + " already exists!");
            return;
        }
        if (counter >= STORAGE_LIMIT) {
            System.out.println("Storage is full, delete some elements!");
            return;
        }
        addElem(index, resume);
        counter++;
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            System.out.println("Resume with uuid " + resume.getUuid() + " not found");
            return;
        }
        storage[index] = resume;
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        int delLength = counter - 1 - index;
        if (index < 0) {
            System.out.println("Resume with uuid " + uuid + " not found");
            return;
        }
        if (delLength > 0) {
            shiftDel(index);
        }
        storage[counter - 1] = null;
        counter--;
    }

    public int size() {
        return counter;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Resume with uuid " + uuid + " not found");
            return null;
        }
        return storage[index];
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, counter);
    }

    protected abstract int getIndex(String uuid);

    protected abstract void addElem(int index, Resume resume);

    protected abstract void shiftDel(int index);
}
