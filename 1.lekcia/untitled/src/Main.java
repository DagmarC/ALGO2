import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Initialize file structure
        Directory root = new Directory("root");
        Directory osu = new Directory("osu");
        Directory stat = new Directory("stat");
        Directory algo = new Directory("algo");

        root.files = new ArrayList<>();
        root.directories = new ArrayList<>();

        osu.files = new ArrayList<>();
        osu.directories = new ArrayList<>();

        stat.files = new ArrayList<>();
        stat.directories = new ArrayList<>();

        algo.files = new ArrayList<>();
        algo.directories = new ArrayList<>();

        root.directories.add(osu);
        root.files.add(new File("Pravidla.txt", 1));
        root.files.add(new File("Rad.txt", 2));

        osu.directories.add(stat);
        osu.directories.add(algo);
        osu.files.add(new File("Predmety.txt", 3));

        stat.files.add(new File("stat.txt", 4));
        stat.files.add(new File("prg.xml", 5));

        algo.files.add(new File("algo.txt", 6));
        algo.files.add(new File("prg.java", 7));


        // Call method
        root.print();
    }
}