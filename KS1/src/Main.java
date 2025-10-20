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



    static void main(String[] args) {

        Persons persons = generateRandomPersons();
        System.out.println(persons);

        System.out.println("===========INSERTION SORT O(nˆ2) - SORT BY AGE===========");
        persons.sortByAge();
        System.out.println(persons);

        Persons persons2 = generateRandomPersons();
        System.out.println(persons);

        System.out.println("===========MERGE SORT O(n*log(n)) - SORT BY HEIGHT===========");
//        persons2.sortByHeight();
        System.out.println(persons2);

        System.out.println("===========BIN SEARCH O(n*log(n)) - FIND BY NAME===========");

        // Test on already sorted array
        Persons sortedPersons = generateRandomPersonsSorted();

        Person result1 = sortedPersons.findPerson("Bea");
        assert result1 != null;
        System.out.printf("Person %s was found.%n", result1);

        Person result2 = sortedPersons.findPerson("Conrad");
        assert result2 != null;
        System.out.printf("Person %s was found.%n", result2);

        String name1 = "Teo";
        Person result3 = sortedPersons.findPerson(name1);
        assert result3 == null;
        System.out.printf("Person %s was not found.\n", name1);

        // Test on randomly generated array

        // Test non-existing name (neither Jozko nor Mrkvicka in the pseudo random space)
        String searchQuery1 = "Jozko Mrkvicka";
        Person noMatch = persons.findPerson(searchQuery1);
        assert noMatch == null;
        System.out.printf("Person %s was not found.\n", searchQuery1);

        // Test if existing person is found
        String searchQuery2 = persons.getPersons()[10].getName();
        Person match = persons.findPerson(searchQuery2);
        assert match != null;
        System.out.printf("Person %s was found. Person matched: %s %n", searchQuery2, match);



    }

    public static Persons generateRandomPersons() {
//        int ageUpperBoundary = 99;
//        int heightUpperBoundary = 198;
//        int heightLowerBoundary = 10;

        Random rand = new Random();
        Persons persons = new Persons(PERSON_LEN);

        for (int i = 0; i < 100; i++) {
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
