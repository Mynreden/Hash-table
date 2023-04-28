import java.util.Objects;

public class Student {
    private String name;
    private int group;
    private float gpa;

    public Student(String name, int group, float gpa){
        this.gpa = gpa;
        this.name = name;
        this.group = group;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = hash * 5 + group;
        hash = hash * 7 + (int) gpa;

        char[] arr = name.toCharArray();
        int m = 0;
        for (char i: arr) m = i + (31 * m);

        hash = hash * 13 + m;
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return group == student.group && Float.compare(student.gpa, gpa) == 0 && Objects.equals(name, student.name);
    }

    @Override
    public String toString(){
        return this.name + ' ' + this.group;
    }
}
