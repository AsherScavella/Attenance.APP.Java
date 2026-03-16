/**
 * A students attendance records.
 *
 * @author Asher Scavella
 * @version 1.0
 * @since 2026.03.16
 */
public class Student {

    /** The student's seat number. */
    private int seat;

    /** The student's name. */
    private String name;

    /** Number of times the student was on time. */
    private int onTime;

    /** Number of times the student was late. */
    private int late;

    /** Number of times the student was excused. */
    private int excused;

    /** Number of times the student was unexcused. */
    private int unexcused;

    /**
     * Default constructor that sets default values.
     * This constructor is private and used by overloaded constructors.
     */
    private Student() {
        seat = 0;
        name = "unknown";
        onTime = 0;
        late = 0;
        excused = 0;
        unexcused = 0;
    } // end of default constructor

    /**
     * This overloaded constructor is mainly used by the ArrayList indexOf method
     * to check whether a seat number is already assigned. It works with the
     * overridden equals method to compare students based on their seat number.
     *
     * @param seat the student's seat number
     * @throws Exception if the setSeat method detects an invalid seat number
     */
    public Student(int seat) throws Exception {
        this();
        setSeat(seat);
    }

    /**
     * Overloaded constructor used to create a student with seat number and name.
     *
     * @param seat the student's seat number
     * @param name the student's name
     * @throws Exception if the seat or name is invalid
     */
    public Student(int seat, String name) throws Exception {
        this();
        setSeat(seat);
        setName(name);
    }

    /**
     * Gets the student's name.
     *
     * @return the student's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the student's seat number.
     *
     * @return the student's seat number
     */
    public int getSeat() {
        return seat;
    }

    /**
     * Gets the number of on-time attendances.
     *
     * @return on-time count
     */
    public int getOnTime() {
        return onTime;
    }

    /**
     * Gets the number of late attendances.
     *
     * @return late count
     */
    public int getLate() {
        return late;
    }

    /**
     * Gets the number of excused attendances.
     *
     * @return excused count
     */
    public int getExcused() {
        return excused;
    }

    /**
     * Gets the number of unexcused attendances.
     *
     * @return unexcused count
     */
    public int getUnexcused() {
        return unexcused;
    }

    /**
     * Sets the student's seat number.
     *
     * @param seat the student's seat number
     * @throws Exception if seat is not between 0 and 55
     */
    public void setSeat(int seat) throws Exception {
        if (seat >= 0 && seat <= 55)
            this.seat = seat;
        else
            throw new Exception("Seat can be less than 1");
    } // end of setSeat method

    /**
     * Sets the student's name.
     *
     * @param name the student's name
     * @throws Exception if the name is null, empty, or blank
     */
    public void setName(String name) throws Exception {
        if (name == null || name.isBlank())
            throw new Exception("Student name can not be blank");
        this.name = name.trim();
    } // end of setName method

    /**
     * Displays the student's attendance totals.
     *
     * <pre>
     * Seat #10 Bob OnTime=1 Late=0 Excused=0 Unexcused=0
     * </pre>
     */
    public void displayAttendance() {
        System.out.print("Seat #" + getSeat() + " " + getName() + " ");
        System.out.print("OnTime=" + getOnTime() + " ");
        System.out.print("Late=" + getLate() + " ");
        System.out.print("Excused=" + getExcused() + " ");
        System.out.print("Unexcused=" + getUnexcused());
    }

    /**
     * Updates the student's attendance count based on the given status.
     *
     * @param status 1=On Time, 2=Late, 3=Excused, 4=Unexcused
     * @throws Exception if status is invalid
     */
    public void updateAttendance(int status) throws Exception {

        switch (status) {
            case 1:
                onTime++;
                break;
            case 2:
                late++;
                break;
            case 3:
                excused++;
                break;
            case 4:
                unexcused++;
                break;
            default:
                throw new Exception("Invalid attendance status = " + status);
        }
    } // end of updateAttendance method

    /**
     * Compares students by seat number only.
     *
     * @param object the object being compared
     * @return true if the seat numbers match, otherwise false
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Student other))
            return false;

        return this.seat == other.getSeat();
    }

    /**
     * Returns the student's seat number and name.
     *
     * @return student seat and name
     */
    @Override
    public String toString() {
        return seat + " " + name;
    }

} // end of Student class
