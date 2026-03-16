import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        try {
            // Section 1
            Course c1 = new Course();
            System.out.print("Enter Section 1's course name: ");
            c1.setName(kb.nextLine());

            while (true) {
                System.out.print("\nEnter " + c1.getName() + " student's name or 'q' to quit: ");
                String studentName = kb.nextLine();

                if (studentName.equalsIgnoreCase("q")) {
                    break;
                }

                System.out.print("Enter " + studentName + " seat number: ");
                int seat = Integer.parseInt(kb.nextLine());
                try {
                    c1.addStudent(studentName, seat);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println("Unable to add student!");
                }
            }

            // Section 2
            Course c2 = new Course();
            System.out.print("\nEnter Section 2's course name: ");
            c2.setName(kb.nextLine());

            while (true) {
                System.out.print("\nEnter " + c2.getName() + " student's name or 'q' to quit: ");
                String studentName = kb.nextLine();

                if (studentName.equalsIgnoreCase("q")) {
                    break;
                }

                System.out.print("Enter " + studentName + " seat number: ");
                int seat = Integer.parseInt(kb.nextLine());

                try {
                    c2.addStudent(studentName, seat);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println("Unable to add student!");
                }
            }

            // Show reports
            System.out.println();
            c1.displaySummary();
            c1.displayDetailReport();

            System.out.println();
            c2.displaySummary();
            c2.displayDetailReport();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        kb.close();
    }
}

