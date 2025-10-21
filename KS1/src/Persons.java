import java.util.Arrays;

public class Persons {
    private Person[] persons;

    public Persons(int n) {
        this.persons = new Person[n];
    }

    public Person[] getPersons() {
        return persons;
    }

    /**
     * The addPerson method adds person to a person array if the idx is within boundaries.
     * Rewrite of the person by another person is possible.
     * Indices range: [0 : len(n)-1]
     *
     * @param person person being added to the array
     * @param idx is the index of the array, where person should be inserted
     * @throws IllegalArgumentException  if the idx is out of range
     * */
    public void addPerson(Person person, int idx) throws IllegalArgumentException {
        if (idx < 0 || idx > persons.length) {
            throw new IllegalArgumentException("Index out of range");
        }
        persons[idx] = person;
    }

    /**
     * Sorts persons by age via insertions sort in O(nˆ2). Algorithm is in-situ (in place).
     * **/
    public void sortByAge() {
        for (int i=1; i < persons.length; i++) {

            Person personToSort = persons[i];

            int j = i-1;
            boolean inserted = false;

            while (j >= 0 && personToSort.getAge() < persons[j].getAge()) {
                persons[j+1] = persons[j];
                j--;
                inserted = true;
            }
            if (inserted) {
                persons[j+1] = personToSort;
            }
        }
    }

    /**
     * Sorts the array of Person objects by height. Internally it uses merge sort O(n*log(n)).
     *
     * Mergesort divides the array recursively until only one element is trivially sorted, then it merges
     * it into one array via comparing elements from both arrays.
     * T(n) = O(n*log(n))
     * **/
    public void sortByHeight(int left, int right) {

        if (left >= right) {
            return;
        }
        int pivot = (left + right) / 2;

        // 'Divide' the array until trivially sorted elements
        sortByHeight(left, pivot);
        sortByHeight(pivot + 1, right);

        // Merge two arrays into one
        merge(persons, left, pivot, right);
    }

    private void merge(Person[] arr, int left, int pivot, int right) {
        // Create 2 new sub arrays LEFT and RIGHT, that will be merged afterward
        int leftSize = pivot - left + 1;  // size of the left subarray
        int rightSize = right - pivot; // size of the right subarray

        Person[] leftArr = new Person[leftSize];
        Person[] rightArr = new Person[rightSize];

        // Fill in the subarrays
        fillInArray(arr, leftArr, leftSize, left);
        fillInArray(arr, rightArr, rightSize, pivot+1);

        // left and right indices of the subarrays
        int i = 0;
        int j = 0;

        // Merge 2 subarrays into the final array
        for (int l = left; l <= right; l++) {
            // left subarray is already inserted, continue with the right part
            if (i >= leftSize && j < rightSize) {
                arr[l] = rightArr[j];
                j++;
            }
            // right subarray is already inserted, continue with the left part
            else if (j >= rightSize && i < leftSize) {
                arr[l] = leftArr[i];
                i++;
            }
            // check if both arrays are not already inserted,
            // but in practice j >= rightSize cannot happen due tu the above condition evaluations,
            // if i >= leftsize  -> it means the right size is, too
            else if (i >= leftSize && j >= rightSize) {
                break;
            }
            // both arrays are being compared
            else if (leftArr[i].getHeight() < rightArr[j].getHeight()) {
                arr[l] = leftArr[i];
                i++;
            } else {
                arr[l] = rightArr[j];
                j++;
            }
        }
    }

    private void fillInArray(Person[] source, Person[] dest, int size, int left) {
        for (int i = 0; i < size; i++) {
            dest[i] = source[left + i];
        }
    }


    /**
     * Sorts the array of Person objects by name. Internally it uses Radix sort.
     * **/
    public void sortByName() {
        // @TODO
    }

    /**
     * findPerson matches person by name
     * @param name: the query that is matching against existing list
     * @throws NullPointerException if the name was not found
     * */
    public Person findPerson(String name) throws NullPointerException {
        if (persons.length == 0) {
            return null;
        }
        sortByName();
        return findPersonByName(name, 0, persons.length - 1);
    }

    private Person findPersonByName(String name, int left, int right) {
        // no match was found
        if (left > right) {
            return null;
        }

        // divide the array into 2 halves
        int mid = (left + right) / 2;
        if (name.equals(persons[mid].getName())) {
            return persons[mid];
        }
        // decide with which half of the array the binary search will continue
        if (name.compareToIgnoreCase(persons[mid].getName()) < 0) {
            // name is less than the mid-name -> go left
            return findPersonByName(name, left, mid - 1);
        }
        // otherwise go right
        return findPersonByName(name, mid+1, right);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Person person : persons) {
            sb.append(person.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

}
