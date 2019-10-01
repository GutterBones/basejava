/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    // storage elements counter
    private int counter;

    void clear() {
        for (int i = 0; i < counter; i++)
            storage[i] = null;
        counter = 0;
    }

    void save(Resume r) {
        storage[counter] = r;
        counter++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < counter; i++) {
            if (storage[i].uuid.equals(uuid))
            return storage[i];
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < counter; i++) {
            if (storage[i].uuid.equals(uuid)) {
                //for (int j = i; j < counter; j++)
                // storage[j] = storage[j+1];
                System.arraycopy(storage, i + 1, storage, i, counter - i);
                counter--;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] buff = new Resume[counter];
        //for (int i = 0; i < counter; i++)
        //      buff[i] = storage[i];
        System.arraycopy(storage, 0, buff, 0, counter);
        return buff;
    }

    int size() {
        return counter;
    }
}
