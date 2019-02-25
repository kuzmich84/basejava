import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    int size = 0;

    public void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    public void save(Resume r) {
        if (r.toString() != "" && r.toString() != null) {
            int index = getIndex(r.toString());
            if (index == storage.length) {
                System.out.println("Storage overflow");
            } else if (index == -1) {
                storage[size] = r;
                size++;

            } else {
                System.out.println("Resume already exist");

            }
        } else {
            System.out.println("Enter correct value");
        }
    }

    public void update(Resume r) {
        int index = getIndex(r.toString());
        if (index != -1) {
            storage[index] = r;

        } else {
            System.out.println("Resume not exist");
        }

    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            return storage[index];


        }
        System.out.println("Resume not exist");
        return null;
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;

        } else {
            System.out.println("Resume don't find");

        }


    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                return i;
            }
        }
        return -1;

    }

}

