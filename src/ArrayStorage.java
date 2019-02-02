/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size=0;

    int size = 0;

    void clear() {
<<<<<<< HEAD
        for (int i=0;i<size;i++){
            storage[i]=null;
        }
        size=0;
    }

    void save(Resume r) {
        if (size < storage.length) {
            storage[size] = r;
            size++;
        }

=======
        for (int i = 0; i < size; i++) {
            storage[i] = null;
            size = 0;
        }
    }

    void save(Resume r) {
        if (r.toString() != "" && r.toString() != null) {
            storage[size] = r;
            size++;
        }
>>>>>>> refs/remotes/origin/master
    }


    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
<<<<<<< HEAD
            if (storage[i].uuid == uuid) {
=======
            if (uuid.equals(storage[i].uuid)) {
>>>>>>> refs/remotes/origin/master
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
<<<<<<< HEAD
=======

>>>>>>> refs/remotes/origin/master
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
<<<<<<< HEAD

            return new Resume[0];
        }


=======
        Resume[] st = new Resume[size];
        for (int i = 0; i < size; i++) {
            st[i] = storage[i];
        }
        return st;
    }
>>>>>>> refs/remotes/origin/master

    int size() {
        return size;
    }
}