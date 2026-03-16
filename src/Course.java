import java.util.ArrayList;
import java.util.List;

/**
 * Use to keep track of a course section made up of multiple students
 * along with the course attendance totals.
 */
public class Course {

    /** The course section name. */
    private String name;

    /** The list of students in the course section. */
    private List<Student> allStudents;

    /**
     * Default constructor that sets the course name to "Unknown"
     * and creates an empty student list.
     */
    public Course() {
        this.name = "Unknown";
        allStudents = new ArrayList<>();
    }

    /**
     * Gets the course name.
     *
     * @return the course name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the course name after validating it is not blank.
     *
     * @param name the course name
     * @throws Exception if the course name is null, empty, or blank
     */
    public void setName(String name) throws Exception {
        if (name == null || name.isBlank())
            throw new Exception("Course name can not be blank");
        this.name = name.trim();
    } // end of setName method

    /**
     * Gets a student by seat number.
     * Uses ArrayList.indexOf with the Student.equals method.
     *
     * @param seat the student's seat number
     * @return the Student object if found, otherwise null
     * @throws Exception if creating the temporary Student causes validation error
     */
    public Student getStudent(int seat) throws Exception {

        int index = allStudents.indexOf(new Student(seat));

        if (index == -1)
            return null;
        else
            return allStudents.get(index);
    }

    /**
     * Adds a student to the course if the seat is not already taken.
     *
     * @param name the student's name
     * @param seat the student's seat number
     * @throws Exception if the seat is already assigned to another student
     */
    public void addStudent(String name, int seat) throws Exception {
        Student student = getStudent(seat);
        if (student == null) {
            allStudents.add(new Student(seat, name));
        } else {
            throw new Exception("Seat #" + seat + " already assigned to " + student.getName() + "!");
        }
    }

    /**
     * Gets the total number of on-time attendances for the course.
     *
     * @return total on-time count
     */
    public int getOnTime() {
        int totalOnTime = 0;

        for (Student student : allStudents) {
            totalOnTime += student.getOnTime();
        }

        return totalOnTime;
    }

    /**
     * Gets the total number of late attendances for the course.
     *
     * @return total late count
     */
    public int getLate() {
        int totalLate = 0;

        for (Student student : allStudents) {
            totalLate += student.getLate();
        }

        return totalLate;
    }

    /**
     * Gets the total number of excused attendances for the course.
     *
     * @return total excused count
     */
    public int getExcuse() {
        int totalExcuse = 0;

        for (Student student : allStudents) {
            totalExcuse += student.getExcused();
        }

        return totalExcuse;
    }

    /**
     * Gets the total number of unexcused attendances for the course.
     *
     * @return total unexcused count
     */
    public int getUnExcuse() {
        int totalUnExcuse = 0;

        for (Student student : allStudents) {
            totalUnExcuse += student.getUnexcused();
        }

        return totalUnExcuse;
    }

    /**
     * Displays the course attendance summary.
     *
     * <pre>
     * 9:00 am OnTime=2 Late=1 Excused=0 Unexcused=1
     * </pre>
     */
    public void displaySummary() {
        System.out.println(name + " OnTime=" + getOnTime() + " Late=" + getLate()
                + " Excused=" + getExcuse()
                + " Unexcused=" + getUnExcuse());
    }

    /**
     * Displays the detailed attendance report for all students in the course.
     *
     * <pre>
     * Seat Name             OnTime Late Excused Unexcused
     * ==== ================ ====== ==== ======= =========
     *   10 Bob                   1    0       0         0
     *   11 Sue                   0    1       0         0
     * </pre>
     */
    public void displayDetailReport() {

        displaySummary();
        System.out.println("Seat Name             OnTime Late Excused Unexcused");
        System.out.println("==== ================ ====== ==== ======= =========");

        for (Student student : allStudents) {
            System.out.printf("%4d %-16s %6d %4d %7d %9d%n",
                    student.getSeat(),
                    student.getName(),
                    student.getOnTime(),
                    student.getLate(),
                    student.getExcused(),
                    student.getUnexcused());
        }

        System.out.println();
    }

    /**
     * Returns the course name as a string.
     *
     * @return the course name
     */
    @Override
    public String toString() {
        return name;
    }
}






