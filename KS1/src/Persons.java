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
     * **/
    public void mergeSort(Person[] persons) {
        // @TODO
    }


    /**
     * Sorts the array of Person objects by name. Internally it uses Radix sort.
     * **/
    public void sortByName() {
        // @TODO
    }

    public Person findPerson(String name) throws NullPointerException {
        if (persons.length == 0) {
            return null;
        }
        sortByName();
        return findPersonByName(name, 0, persons.length - 1);
    }

    private Person findPersonByName(String name, int left, int right) {
        // sort the array, without it the binary search us not working
        System.out.println("left: " + left + " right: " + right);

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
