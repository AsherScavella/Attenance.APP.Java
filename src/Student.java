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


    public Student (int seat) {
        this();
        this.seat = seat;
        //TODO: call the setSeat
    }

    public Student(int seat, String name){
        this.seat = seat;
        this.name = name;
        //TODO: call the setSeat
        //TODO: call the setName
        // end of overload constructor


    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        if (seat < 1) {
            throw new IllegalArgumentException("seat must be greater than 0");
        }
        else {
            this.seat = seat;
        }
    }

    public int getOnTime() {
        return onTime;
    }

    public void setOnTime(int onTime) {
        this.onTime = onTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name cannot be null or empty");
        }else {
            this.name = name;
        }
    }

    public int getLate() {
        return late;
    }

    public void setLate(int late) {
        this.late = late;
    }

    public int getExcused() {
        return excused;
    }

    public void setExcused(int excused) {
        this.excused = excused;
    }

    public int getUnexcused() {
        return unexcused;
    }

    public void setUnexcused(int unexcused) {
        this.unexcused = unexcused;
    }

    public void updateAttendance(int status){
        if (status <= 4 && status >= 1) {

            if (status == 1) {
                this.onTime++;
            }
            else if (status == 2) {
                this.late++;
            }
            else if (status == 3) {
                this.excused++;
            }
            else if (status == 4) {
                this.unexcused++;
            }
        }
        else{
            throw new IllegalArgumentException("Invalid attendance status: " + status);
        }
    }

    @Override
    public String toString(){
        return seat + " " + name;
    }

}
// end of student class


