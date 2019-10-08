/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    // storage elements counter
    private int counter;

    void clear() {
        for (int i = 0; i < counter; i++) {
            storage[i] = null;
        }
        counter = 0;
    }

    void save(Resume resume) {
        for (int i = 0; i < counter; i++) {
            if (storage[i].uuid.equals(resume.uuid)) {
                System.out.println("Resume already exists!");
                return;
            }
        }
        if (counter >= 10000) {
            System.out.println("Storage is full, delete some elements!");
            return;
        }
        storage[counter] = resume;
        counter++;
    }


    void update(Resume resume) {
        for (int i = 0; i < counter; i++) {
            if (storage[i].uuid.equals(resume.uuid)) {
                storage[i] = resume;
                return;
            }
        }
        System.out.println("Resume not found");
    }

    Resume get(String uuid) {
        for (int i = 0; i < counter; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        System.out.println("Resume not found");
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < counter; i++) {
            if (storage[i].uuid.equals(uuid)) {
                if (counter - 1 - i >= 0) {
                    System.arraycopy(storage, i + 1, storage, i, counter - 1 - i);
                    storage[counter - 1] = null;
                }
                //for (int j = i; j < counter-1; j++)
                //    storage[j] = storage[j+1];
                //storage [counter-1] = null;
                counter--;
                return;
            }
        }
        System.out.println("Resume not found");
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumes = new Resume[counter];
        //for (int i = 0; i < counter; i++)
        //      resumes[i] = storage[i];
        System.arraycopy(storage, 0, resumes, 0, counter);
        return resumes;
    }

    int size() {
        return counter;
    }
}
