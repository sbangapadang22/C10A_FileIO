package ScoreTrakker;

/**
 *  Object for storing, comparing, and oututting a student's name and score
 * 
 * @author Sam Bangapadang
 * @author Matt Jackson
 *
 */
public class Student implements Comparable<Student> {
    private String name;
    private int score;
    
    /**
	 * Initialize student with given name and score
	 * @param name	student's name as a string
	 * @param score	student's score as an int
	 */
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }
    
    public int getScore() {
        return score;
    }

    /**
	 * Override of method of Comparable. Used in sorting. Compare by store if not same, else compare by name
	 * 
	 * @param other  object being compared to (Student)
	 */
    @Override
    public int compareTo(Student other) {
        int scoreComparison = Integer.compare(this.score, other.score);
        if (scoreComparison == 0) {
            return this.name.compareTo(other.name); // Compare by name if scores are equal
        }
        return scoreComparison;
    }

    /**
	 * Override of toString. Used to print data in format "Name Score"
	 */
    @Override
    public String toString() {
        return name + " " + score;
    }
}
