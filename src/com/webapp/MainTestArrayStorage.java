package com.webapp;

import com.webapp.model.Resume;
import com.webapp.storage.ArrayStorage;
import com.webapp.storage.Storage;

/**
 * Test for your com.webapp.storage.ArrayStorage implementation
 */
public class MainTestArrayStorage {
    private static final Storage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume();
        r1.setUuid("uuid1");
        Resume r2 = new Resume();
        r2.setUuid("uuid2");
        Resume r3 = new Resume();
        r3.setUuid("uuid3");
        Resume r4 = new Resume();
        r4.setUuid("uuid4");

        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        printAll();
        ARRAY_STORAGE.delete(r1.getUuid());
        printAll();

        printAll();
        printHashAll();
        ARRAY_STORAGE.update(r4);
        printHashAll();
        printAll();

        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());

        Resume[] resumes = new Resume[10_001];
        for (int i = 0; i < resumes.length; i++) {
            resumes[i] = new Resume();
            resumes[i].setUuid("R" + i);
            ARRAY_STORAGE.save(resumes[i]);
        }
        printAll();

    }

    private static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }

    private static void printHashAll() {
        System.out.println("\nHash All");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.println(r.hashCode());
        }
    }
}
