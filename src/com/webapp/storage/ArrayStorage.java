package com.webapp.storage;

import com.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];
    // storage elements counter
    private int counter;

    public void clear() {
        Arrays.fill(storage, 0, counter, null);
        counter = 0;
    }

    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index != -1) {
            System.out.println("Resume with uuid " + resume.getUuid() + " already exists!");
            return;
        }
        if (counter >= storage.length) {
            System.out.println("Storage is full, delete some elements!");
            return;
        }
        storage[counter] = resume;
        counter++;
    }


    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index == -1) {
            System.out.println("Resume with uuid " + resume.getUuid() + " not found");
            return;
        }
        storage[index] = resume;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume with uuid " + uuid + " not found");
            return null;
        }
        return storage[index];
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume with uuid " + uuid + " not found");
            return;
        }
        System.arraycopy(storage, index + 1, storage, index, counter - 1 - index);
        storage[counter - 1] = null;
        counter--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, counter);
    }

    public int size() {
        return counter;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < counter; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
