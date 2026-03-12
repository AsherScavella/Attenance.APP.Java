public class Main {

    // test invalid jersey
    public static void main(String[] args) {
        /*
    }
        try {
            Student s1 = new Student(-1);
            System.out.println(s1);
        } catch (
                Exception e) {
            System.out.println(e.getMessage());
        }

        // test invalid name
        try {
            Student s2 = new Student(1, "Bob");
            System.out.println(s2);
        } catch (
                Exception e) {
            System.out.println(e.getMessage());
        }

        // test a valid student
        try {
            Student s3 = new Student(1, "BOb");
            System.out.println(s3);
        } catch (
                Exception e) {
            System.out.println(e.getMessage());
        }

        // test a updateAttendance
        try {
            Student s4 = new Student(1, "BOb");
            s4.updateAttendance(1);
            s4.updateAttendance(1);

            s4.updateAttendance(2);
            s4.updateAttendance(2);
            s4.updateAttendance(2);


            s4.displayAttendance();
            s4.updateAttendance(4);


            s4.updateAttendance(5);
        } catch (
                Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Student s5 = new Student(1, "Bob");
            Student s6 = new Student(1, "Sue");
            System.out.println(s5.equals(s6));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        */


        {
            try {
                Course c1 = new Course();
                c1.setName("Section 9:00 am");
                System.out.println(c1);

                c1.addStudent("Bob",1);
                c1.addStudent("Sue",2);

             c1.displaySummary();


            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

