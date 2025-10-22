import java.util.Random;

public class Main {
    private static final int PERSON_LEN = 100;
    private static final int AGE_UPPER_BOUNDARY = 99;
    private static final int HEIGHT_UPPER_BOUNDARY = 198;
    private static final int HEIGHT_LOWER_BOUNDARY = 10;

    private static final String[] FIRST_NAMES = {
            "Adam", "Peter", "Marek", "Tomas", "Lukas", "Filip", "Jan", "Michal", "Andrej", "Martin",
            "Jana", "Lucia", "Katarina", "Zuzana", "Monika", "Petra", "Veronika", "Ivana", "Simona", "Michaela",
            "Kristina", "Barbora", "Dominika", "Natalia", "Laura", "Lenka", "Andrea", "Silvia", "Alena", "Beata"
    };

    private static final String[] LAST_NAMES = {
            "Kovac", "Novak", "Hrivnak", "Kral", "Urban", "Horvath", "Svetlik", "Benko", "Cerny", "Toth",
            "Varga", "Balaz", "Hric", "Kollar", "Mraz", "Ondrejka", "Polak", "Rehak", "Sloboda", "Valach",
            "Duris", "Farkas", "Gregor", "Hudak", "Jurik", "Kubik", "Lacko", "Mikula", "Nagy", "Olejnik",
            "Pavlik", "Rybak", "Sabo", "Toman", "Vesely", "Zeman", "Kovacik", "Bartos", "Ruzicka", "Siska"
    };



    public static void main(String[] args) {

        Persons persons = generateRandomPersons();
        System.out.println("===========UNSORTED ARRAY===========");
        System.out.println(persons);


        System.out.println("===========INSERTION SORT O(nˆ2) - SORT BY AGE===========");
        persons.sortByAge();
        System.out.println(persons);


        System.out.println("===========MERGE SORT O(n*log(n)) - SORT BY HEIGHT===========");
        persons.sortByHeight(0, persons.getPersons().length - 1);
        System.out.println(persons);


        System.out.println("===========BIN SEARCH O(n*log(n)) - FIND BY NAME - SORTED ARRAY===========");
        // Test on already sorted array
        Persons sortedPersons = generateRandomPersonsSorted();
        System.out.println("sortedPersons: \n" + sortedPersons);

        Person result1 = sortedPersons.findPerson("Bea");
        printResult(result1, "Bea");

        Person result2 = sortedPersons.findPerson("Conrad");
        printResult(result2, "Conrad");

        Person result3 = sortedPersons.findPerson("Teo");
        printResult(result3, "NULL");


        System.out.println("\n===========BIN SEARCH O(n*log(n)) - FIND BY NAME - UNSORTED ARRAY===========");
//        // Test non-existing name (neither Jozko nor Mrkvicka in the pseudo random space)
        String searchQuery1 = "Jozko Mrkvicka";
        Person noMatch = persons.findPerson(searchQuery1);
        printResult(noMatch, "NULL");
//
//        // Test if existing person is found
        String searchQuery2 = persons.getPersons()[10].getName();
        Person match = persons.findPerson(searchQuery2);
        printResult(match, searchQuery2);


        System.out.println("\n===========SORT BY NAME RESULT===========");
        System.out.println(persons);

    }

    private static void printResult(Person result, String expectedResult) {
        if (result == null) {
            System.out.println("No results found ----> expected: " + expectedResult );
        } else {
            System.out.printf("Person %s should BE FOUND. Expected: %s.\n", expectedResult, result);
        }
    }

    public static Persons generateRandomPersons() {
        Random rand = new Random();
        Persons persons = new Persons(PERSON_LEN);

        for (int i = 0; i < PERSON_LEN; i++) {
            // Init random variables for person
            int age = rand.nextInt(AGE_UPPER_BOUNDARY) + 1;
            int height = rand.nextInt(HEIGHT_UPPER_BOUNDARY - HEIGHT_LOWER_BOUNDARY) + HEIGHT_LOWER_BOUNDARY;

            int name_idx = rand.nextInt(FIRST_NAMES.length);
            int surname_idx = rand.nextInt(LAST_NAMES.length);

            String name = FIRST_NAMES[name_idx] +  " " + LAST_NAMES[surname_idx];

            // Create new person with random variables
            Person person = new Person(name, age, height);

            // Add person to persons array
            persons.addPerson(person, i);
    }
        return persons;
    }

    public static Persons generateRandomPersonsSorted() {
        Person a  = new Person("Alex", 133, 12);
        Person b  = new Person("Bea", 167, 22);
        Person c  = new Person("Conrad", 100, 3);

        Persons persons = new Persons(3);

        persons.addPerson(a, 0);
        persons.addPerson(b, 1);
        persons.addPerson(c, 2);

        return persons;
    }
}
