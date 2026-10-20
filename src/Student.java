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



}