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
        if (student == null) {
            allStudents.add(new Student(seat, name));
        } else {
            throw new Exception("Seat #" + seat + " already assigned to " + student.getName() + "!");
        }
    }

    public int getOnTime() {
        int totalOnTime = 0;

        for (Student player : allStudents) {
            totalOnTime += player.getOnTime();
        }

        return totalOnTime;
    }

    public int getLate() {
        int totalLate = 0;

        for (Student player : allStudents) {
            totalLate += player.getLate();
        }

        return totalLate;
    }


        public int getExcuse() {
            int totalExcuse = 0;

            for (Student player : allStudents) {
                totalExcuse += player.getOnTime();
            }

            return totalExcuse;
        }

    public int getUnExcuse() {
        int totalUnExcuse = 0;

        for (Student player : allStudents) {
            totalUnExcuse += player.getOnTime();
        }

        return totalUnExcuse;
    }

    public void displaySummary() {
        System.out.println( name + " OnTime=" + getOnTime() + " Late=" + getLate()
       + " Excused=" + getExcuse()
        + " Unexcused=" + getUnExcuse());
    }


    @Override
        public String toString () {
            return name;
        }

    }


