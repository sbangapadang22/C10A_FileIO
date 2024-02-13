package ScoreTrakker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *  Object for parsing student score files and outputting the information.
 * 
 * @author Sam Bangapadang
 * @author Matt Jackson
 *
 */
public class ScoreTrakker {
    private ArrayList<Student> students;
    
    private String[] files = {"scores.txt", "badscore.txt", "nofile.txt"};
    
    /**
	 * Initialize tracker with empty ArrayList for Student objects
	 */
    public ScoreTrakker() {
        students = new ArrayList<>();
    }
    
    /**
	 * Method for populating `students` ArrayList with Student objects.
	 * 
	 * @param fileName	path to file that contains structured student score data
	 * 
	 * @throws FileNotFoundException	exception propagated when file is not found in file system
	 */
    public void loadDataFile(String fileName) throws FileNotFoundException {
        students.clear(); // Clear existing data
        try {
            Scanner scanner = new Scanner(new File(fileName));
            String scoreStr = null, name = null;
            while (scanner.hasNextLine()) { // iterate through each line until EOF
                name = scanner.nextLine();
                try {
                	scoreStr = scanner.nextLine(); // save score as String
                    int score = Integer.parseInt(scoreStr); // attempt to cast to Integer
                    students.add(new Student(name, score));
                } catch (NumberFormatException e) {
                	// output to System.out, and continue parsing from next line
                    System.out.println("\nIncorrect format for " + name + " not a valid score: " + scoreStr);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw e; // Propagate FileNotFoundException to processFiles()
        }
    }

    /**
	 * Sorts and outputs student score data in System.out
	 */
    public void printInOrder() {
        System.out.println("\nStudent Score List");
        Collections.sort(students);
        for (Student student : students) {
            System.out.println(student);
        }
    }
    
    /**
	 * Iterates through `files` and evokes loadDataFile and printInOrder. Outputs exception if FileNotFoundException is propagated
	 */
    public void processFiles() {
        for (String fileName : files) { // loop through files in instance variable `files`
            try {
                loadDataFile(fileName);
                printInOrder();
            } catch (FileNotFoundException e) { // throw the error if the exception has been propagated
                System.out.println("\nCan't open file: " + fileName);
            }
        }
    }
    
    public static void main(String[] args) {
        ScoreTrakker tracker = new ScoreTrakker();
        tracker.processFiles();
    }
}
