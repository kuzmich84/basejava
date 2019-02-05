import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    int size = 0;

    void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    void save(Resume r) {
        if (r.toString() != "" && r.toString() != null) {

            for (int i = 0; i < size; i++) {
                if (storage[i].uuid.equals(r.toString())) {
                    System.out.println("Resume already exists");
                    return;
                }
            }
            storage[size] = r;
            size++;


        } else {
            System.out.println("Enter correct value");
        }
    }


    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
                return;
            }
        }
        for (int i = 0; i < size; i++) {
            if (!storage[i].uuid.equals(uuid)) {
                System.out.println("Resume don't find");
                break;
            }

        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }
}
