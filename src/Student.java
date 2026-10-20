import java.util.HashMap;
import java.util.Map;

public class Student{
    private int id;
    private String name;
    private Map<String, Float> grade;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.grade = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Float> getGrade() {
        return grade;
    }

    // Encapsulation with validation (scores between 0 and 100)
    public void setGrade(String course, Float score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score must be between 0 and 100.");
        }
        grade.put(course, score);
    }

    public float calculateGPA() {
        if (grade.isEmpty()) return 0;
        float sum = 0;
        for (float score : grade.values()) {
            sum += convertScoreToGPA(score);
        }
        return sum / grade.size();
    }

    private float convertScoreToGPA(Float score) {
        if (score >= 85) return 4;
        if (score >= 70) return 3;
        if (score >= 55) return 2;
        if (score >= 40) return 1;
        return 0;
    }

}