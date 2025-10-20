import java.util.ArrayList;

public class Directory {

    public String name;
    public ArrayList<Directory> directories;
    public ArrayList<File> files;

    public Directory(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println("Directory " + this.name + " in recursion tree.");

        for (Directory child_dir : this.directories) {
            child_dir.print();
        }
        System.out.println("Recursion tree directories has been printed. Print Files and go out of recursion tree.\n");

        System.out.println("Directory name: " + this.name);
        System.out.println("Directory Files:");
        printFiles(this);
    }

    public void printFiles(Directory directory) {
        for (File file : directory.files) {
            System.out.println("\t - file name: " + file.name + ", file size: " + file.size);
        }
    }

}
