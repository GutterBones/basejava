package com.webapp.storage;

import com.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];
    // storage elements counter
    private int counter;

    public void clear() {
        for (int i = 0; i < counter; i++) {
            storage[i] = null;
        }
        counter = 0;
    }

    public void save(Resume resume) {
        //for (int i = 0; i < counter; i++) {
        //    if (storage[i].uuid.equals(resume.uuid)) {
        //        System.out.println("Resume already exists!");
        //        return;
        //    }
        //}
        int present = presentInd(resume.getUuid());
        if (!(present == -1)) {
            System.out.println("Resume already exists!");
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
        //for (int i = 0; i < counter; i++) {
        //    if (storage[i].uuid.equals(resume.uuid)) {
        //        storage[i] = resume;
        //        return;
        //    }
        //}
        int present = presentInd(resume.getUuid());
        if (present == -1) {
            System.out.println("Resume not found");
        } else {
            storage[present] = resume;
        }
    }

    public Resume get(String uuid) {
        //for (int i = 0; i < counter; i++) {
        //    if (storage[i].uuid.equals(uuid)) {
        //        return storage[i];
        //    }
        //}
        //System.out.println("Resume not found");
        int present = presentInd(uuid);
        if (present == -1) {
            System.out.println("Resume not found");
        } else {
            return storage[present];
        }
        return null;
    }

    public void delete(String uuid) {
        //for (int i = 0; i < counter; i++) {
        //    if (storage[i].uuid.equals(uuid)) {
        //        if (counter - 1 - i >= 0) {
        //            System.arraycopy(storage, i + 1, storage, i, counter - 1 - i);
        //            storage[counter - 1] = null;
        //        }
        //for (int j = i; j < counter-1; j++)
        //    storage[j] = storage[j+1];
        //storage [counter-1] = null;
        //       counter--;
        //        return;
        //    }
        //}
        int present = presentInd(uuid);
        if (present == -1) {
            System.out.println("Resume not found");
        } else {
            if (counter - 1 - present >= 0) {
                System.arraycopy(storage, present + 1, storage, present, counter - 1 - present);
                storage[counter - 1] = null;
                counter--;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] resumes = new Resume[counter];
        //for (int i = 0; i < counter; i++)
        //      resumes[i] = storage[i];
        System.arraycopy(storage, 0, resumes, 0, counter);
        return resumes;
    }

    public int size() {
        return counter;
    }

    private int presentInd(String uuid) {
        for (int i = 0; i < counter; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
