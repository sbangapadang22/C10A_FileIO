package ScoreTrakker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScoreTrakker {
    private ArrayList<Student> students;

    public ScoreTrakker() {
        students = new ArrayList<>();
    }

    public void loadDataFile(String fileName) {
        students.clear(); // Clear existing data
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                String name = scanner.nextLine();
                int score = Integer.parseInt(scanner.nextLine());
                students.add(new Student(name, score));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }

    public void printInOrder() {
        Collections.sort(students);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void processFiles() {
        loadDataFile("scores.txt");
        printInOrder();
    }

    public static void main(String[] args) {
        ScoreTrakker tracker = new ScoreTrakker();
        System.out.println("Student Score List");
        tracker.processFiles();
    }
}
