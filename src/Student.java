import java.util.Objects;

public class Student {
    private String name;
    private int group;
    private int id;
    private static int numbers = 0;

    public Student(){
        this.name = "No-name";
        this.group = 0;
        this.id = numbers;
        numbers++;
    }

    public Student(String name, int group){
        this.id = numbers;
        numbers++;
        this.name = name;
        this.group = group;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = hash * 5 + group;
        hash = hash * 7 + id;

        char[] arr = name.toCharArray();
        int m = 0;
        for (char i: arr) m = i + (31 * m);

        hash = hash * 13 + m;
        return hash;
    }

    @Override
    public String toString(){
        return this.id + ". " + this.name;
    }
}
