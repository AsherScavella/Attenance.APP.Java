public class Student {
    private int seat;
    private String name;
    private int onTime;
    private int late;
    private int excused;
    private int unexcused;


    private Student(){
        seat = 0;
        name = "unknown";
        onTime = 0;
        late = 0;
        excused = 0;
        unexcused = 0;
    }// end of default constructor


    public Student (int seat) throws Exception {
        this();
       setSeat(seat);
    }

    public Student(int seat, String name) throws Exception {
        this();
        setSeat(seat);
        setName(name);
        //TODO: call the setSeat
        //TODO: call the setName
        // end of overload constructor
    }


    public String getName() {
        return name;
    }

    public int getSeat() {
        return seat;
    }

    public int getOnTime() {
        return onTime;
    }


    public int getLate() {
        return late;
    }

    public int getExcused() {
        return excused;
    }


    public int getUnexcused() {
        return unexcused;
    }



    public void setSeat(int seat) throws Exception {
        if (seat >= 0 && seat <= 55)
            this.seat = seat;
        else
            throw new Exception("Seat can be less than 1");
    } // end of setSeat method



    public void setName(String name) throws Exception {
        if (name == null || name. isBlank())
            throw new Exception("Student name can not be blank");
        this.name = name.trim();
    } // end of setName method

    public void displayAttendance() {
        System.out.println(this);
        System.out.print("OnTime" + getOnTime() + " ");
        System.out.print("Late=" + getLate() + " ");
        System.out.print("Excused=" + getExcused() + " ");
        System.out.print("Unexcused=" + getUnexcused() );
    }


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
    } // end of updateStats method



    @Override
    public boolean equals(Object object) {

        // This uses pattern matching with instanceof,
        // which was introduced in Java 16.
        // It combines the type check with a variable declaration
        if(!(object instanceof Student other))
            return false;

        return this.seat == other.getSeat();
    } // end of override equals



    @Override
    public String toString(){
        return seat + " " + name;
    }

}
// end of student class


