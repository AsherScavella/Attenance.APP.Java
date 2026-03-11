import java.util.ArrayList;
import java.util.List;

public class Course {
    private String name;
    private List<Student> allStudents;

    public Course () {
        this.name = "Unknown";
        allStudents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (name == null || name. isBlank())
            throw new Exception("Course name can not be blank");
        this.name = name.trim();
    } // end of setName method


    public Student getStudent(int seat) throws Exception {

        int index = allStudents.indexOf(new Student(seat));

        if (index == -1)
            return null;
        else
            return allStudents.get(index);


    }

    public void addStudent(String name, int seat) throws Exception {
        Student student = getStudent(seat);
        if(student == null) {
            allStudents.add(new Student(seat, name));
        } else {
            throw new Exception("Seat #" + seat + " already assigned to " + student.getName() + "!");
        }
    }
    
    @Override
    public String toString(){
        return  name;
    }
}
