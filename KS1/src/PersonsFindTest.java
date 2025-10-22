import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class PersonsFindTest {

    private Persons persons;
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

    @BeforeEach
    void setup() {
        persons = generateRandomPersons();
    }

    @Test
    void testFindExistingPerson() {
        Person[] persons = this.persons.getPersons();
        Person randomPerson = persons[new Random().nextInt(persons.length)];
        String name = randomPerson.getName();

        Person found = this.persons.findPerson(name);
        assertNotNull(found, "Expected person to be found: " + name);
        assertEquals(name, found.getName());
    }

    @Test
    void testFindNonExistingPerson() {
        String nonExistingName = "Jozko Mrkvicka";
        Person found = persons.findPerson(nonExistingName);
        assertNull(found, "Expected no person to be found with name: " + nonExistingName);
    }

    @Test
    void testFindCaseInsensitivePerson() {
        Person[] persons = this.persons.getPersons();
        Person randomPerson = persons[new Random().nextInt(persons.length)];
        String name = randomPerson.getName();

        Person found = this.persons.findPerson(name.toLowerCase());
        assertNotNull(found, "Expected person to be found: " + name);
        assertEquals(found.getName(), name);
    }


    private static Persons generateRandomPersons() {
        Random rand = new Random();
        Persons persons = new Persons(PERSON_LEN);

        for (int i = 0; i < PERSON_LEN; i++) {
            int age = rand.nextInt(AGE_UPPER_BOUNDARY) + 1;
            int height = rand.nextInt(HEIGHT_UPPER_BOUNDARY - HEIGHT_LOWER_BOUNDARY) + HEIGHT_LOWER_BOUNDARY;

            int name_idx = rand.nextInt(FIRST_NAMES.length);
            int surname_idx = rand.nextInt(LAST_NAMES.length);

            String name = FIRST_NAMES[name_idx] + " " + LAST_NAMES[surname_idx];

            Person person = new Person(name, age, height);
            persons.addPerson(person, i);
        }
        return persons;
    }
}
