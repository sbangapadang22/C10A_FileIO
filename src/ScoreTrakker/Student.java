package ScoreTrakker;

public class Student implements Comparable<Student> {
    private String name;
    private int score;

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

    // Comparing students based on score. If scores are equal, compare by name.
    @Override
    public int compareTo(Student other) {
        int scoreComparison = Integer.compare(this.score, other.score);
        if (scoreComparison == 0) {
            return this.name.compareTo(other.name); // Compare by name if scores are equal
        }
        return scoreComparison;
    }

    // Format: "Name Score"
    @Override
    public String toString() {
        return name + " " + score;
    }
}
