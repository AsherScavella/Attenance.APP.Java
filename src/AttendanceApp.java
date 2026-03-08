/**
 * The Attendance App ONLY keeps track of attendance for two course sections.
 * This is because it's similar to the Basketball scoreboard app that only keeps track of an Away and Home teams stats.
 *
 * @author Debbie Johnson
 * @version 1.0 beta
 * @since 2025.02.21
 * @see <a href="https://github.com/dejohns2/JavaSection3_AttendanceApp_Spring2025.git">GitHub Repository</a>
 */
public class AttendanceApp {

	/** Standard char double dash line (50 characters long) for display output */
	private static final String DOUBLE_DASH_LINE = String.format("%50s", "").replace(' ', '=');

	/** Standard single dash line (same length as double dash line) for display output */
	private static final String SINGLE_DASH_LINE = DOUBLE_DASH_LINE.replace('=', '-');

	/** The first course section */
	Course section1;

	/** The second course section. */
	Course section2;

	/** The default constructor that creates two empty courses to maintain attendance for. */
	public AttendanceApp() {
		section1 = new Course();
		section2 = new Course();
 	} // end of default constructor

	/**
	 * Display the attendance app header.
	 * <u>Example:</u>
	 * <pre>
	 * ==================================================
	 * Welcome to the Attendance App
	 * ==================================================
	 * </pre>
	 */
    private void displayAppHeading() {
    	
		System.out.println(DOUBLE_DASH_LINE);
		System.out.println("Welcome to the Attendance App");
		System.out.println(DOUBLE_DASH_LINE);
		System.out.println();
		
    } // end of displayAppHeading

	/**
	 * Set up the courses by getting the course name, plus the student names and seats.
	 * <u>Example</u>
	 * <pre>
	 * Enter Section 1's course name: 9:00 am
	 * Enter Section 2's course name: 10:00 am
	 * </pre>
	 * @throws Exception if the course or student setters throws errors back due to invalid user input.
	 */
    private void setupCourses() throws Exception {

		String courseName;

		courseName = Input.getLine("Enter Section 1's course name: ");
		section1.setName(courseName);
		setupStudents(section1);

		System.out.println();

		courseName = Input.getLine("Enter Section 2's course name: ");
		section2.setName(courseName);
		setupStudents(section2);
    } // end of setupCourses method

	/**
	 * Set up the students for the course.
	 * <u>Example:</u>
	 * <pre>
	 * Enter 9:00 am student's name or 'q' to quit: Bob
	 * Enter Bob seat number: 10
	 *
	 * Enter 9:00 am student's name or 'q' to quit: Sue
	 * Enter Sue seat number: 10
	 * Seat: 10 is already assigned to Bob!
	 * Unable to add student!
	 * </pre>
	 * @param course the course to set students for
	 */
	private void setupStudents(Course course) {
    	String courseName = course.getName();
    	String studentName;
    	int studentSeat;

    	while (true) {
			System.out.println();
			studentName = Input.getLine("Enter " + courseName + " student's name or 'q' to quit: ");
			
			if (studentName.equals("q"))
				return;
			
			try {
				studentSeat = Input.getIntRange("Enter " + studentName + " seat number: ", 0, 55);
				course.addStudent(studentSeat, studentName);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Unable to add student!");
			}
			
    	} // end of while
		    	
    } // end of setupStudents method

	/**
	 * Displays the main menu, get the user's input, and call the appropriate method.
	 * <u>Example:</u>
	 * <pre>
	 * --------------------------------------------------
	 * Main Menu
	 * --------------------------------------------------
	 * 0 = End Attendance App
	 * 1 = Take 9:00 am Attendance
	 * 2 = Take 10:00 am Attendance
	 * 3 = Display All Attendance Report
	 * --------------------------------------------------
	 * Menu Choice: 3
	 * --------------------------------------------------
	 * </pre>
	 * @throws Exception if any of the menu options throws an error back to this method
	 */
	private void mainMenu() throws Exception {
    	
    	boolean keepLooping = true;
    	int userInput;
    	
    	System.out.println();
    	System.out.println(DOUBLE_DASH_LINE);
    	System.out.println("Recording Attendance!");
    	System.out.println(DOUBLE_DASH_LINE);
    	System.out.println();
    	
    	while (keepLooping) {
    		
    		System.out.println(SINGLE_DASH_LINE);
    		System.out.println("Main Menu");
    		System.out.println(SINGLE_DASH_LINE);
    		
    		System.out.println("0 = End Attendance App");
    		System.out.println("1 = Take " + section1.getName() + " Attendance");
    		System.out.println("2 = Take " + section2.getName() + " Attendance");
    		System.out.println("3 = Display All Attendance Report");
    		
    		System.out.println(SINGLE_DASH_LINE);
    		userInput = Input.getIntRange("Menu Choice: ", 0, 3);
    		System.out.println(SINGLE_DASH_LINE);
    		
    		System.out.println();
    		
    		switch (userInput) {
    		case 0:
    			keepLooping = false;
        		System.out.println();
        		break;
        		
    		case 1:
				courseAttendance(section1);
				break;
				
    		case 2:
   				courseAttendance(section2);
        		break;
        		
    		case 3:
    			displayDetailReports();
    			break;
    			
    		default:
    			System.out.println("Invalid menu choice = " + userInput);
    			
    		} // end of switch
    	} // end of while

    } // end of mainMenu method

	/**
	 * Take attendance for a specific course.
	 * <u>Example:</u>
	 * <pre>
	 * Enter 9:00 am's Student Seat or 0 to quit: 1
	 * Invalid seat, please try again!
	 * Enter 9:00 am's Student Seat or 0 to quit: 10
	 * </pre>
	 * @param course the course to take attendance for
	 * @throws Exception if any of the calling methods returns an error back to this method
	 */
	private void courseAttendance(Course course) throws Exception {

    	int studentSeat;
    	Student student;

		while (true) {
			studentSeat = Input.getIntRange("Enter " + course.getName() + "'s Student Seat or 0 to quit: ", 0, 55);

			if (studentSeat == 0) break;

			student = course.getStudent(studentSeat);
			
			if (student == null) {
				System.out.println("Invalid seat, please try again!");
				continue;
			}
			
			studentAttendance(student);

		}
			
		System.out.println();
		System.out.println(SINGLE_DASH_LINE);
		course.displaySummaryReport();
		System.out.println(SINGLE_DASH_LINE);
		System.out.println();

	} // end of courseAttendance method

	/**
	 * Take attendance for a specific student.
	 * <u>Example:</u>
	 * <pre>
	 * --------------------------------------------------
	 * Enter #10 Bob Attendance
	 * --------------------------------------------------
	 * 1 = On Time
	 * 2 = Late
	 * 3 = Excused
	 * 4 = Unexcused
	 * --------------------------------------------------
	 * Enter Status: 1
	 * --------------------------------------------------
	 * Seat #10 Bob OnTime=1 Late=0 Excused=0 Unexcused=0
	 * </pre>
	 * @param student the student to take attendance for
	 * @throws Exception if a calling method throws an error back to this method
	 */
	private void studentAttendance(Student student) throws Exception {
    	int status;

		System.out.println();
		
		System.out.println(SINGLE_DASH_LINE);
		System.out.println("Enter #" + student.getSeat() + " " + student.getName() + " Attendance");
		System.out.println(SINGLE_DASH_LINE);

		System.out.println("1 = On Time");
		System.out.println("2 = Late");
		System.out.println("3 = Excused");
		System.out.println("4 = Unexcused");

		System.out.println(SINGLE_DASH_LINE);
		status = Input.getIntRange("Enter Status: ", 1, 4);
		System.out.println(SINGLE_DASH_LINE);

		student.updateAttendance(status);
		student.displayAttendance();
		System.out.println();
    } // end of studentAttendance method

	/**
	 * Display the detail attendance report for both course sections.
	 * <u>Example:</u>
	 * <pre>
	 * 9:00 am OnTime=1 Late=1 Excused=0 Unexcused=0
	 * Seat   Name            OnTime Late Excused Unexcused
	 * ==== =============== ====== ==== ======= =========
	 *   10 Bob                  0    0       0         1
	 *   11 Sue                  0    0       1         0
	 *
	 * 10:00 am OnTime=0 Late=0 Excused=1 Unexcused=1
	 * Seat   Name            OnTime Late Excused Unexcused
	 * ==== =============== ====== ==== ======= =========
	 *    1 Joe                  0    1       0         0
	 *    2 Tom                  1    0       0         0
	 * </pre>
	 */
	private void displayDetailReports() {

    	section1.displayDetailReport();
    	section2.displayDetailReport();

    } // end of displayDetailReports method

	/**
	 * Creates the AttendanceApp object, displays the app's header,
	 * and then calls the main menu method
	 * that keeps the program looping until the user wants to quiz.
	 * @param args there are no start up args used for this app
     */
	public static void main(String[] args) {

		AttendanceApp app = new AttendanceApp();
		
		app.displayAppHeading();
		
		try {
			app.setupCourses();
			app.mainMenu();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Sorry but this program ended with an error. Please contact Princess Debbie!");
		}
		
		Input.sc.close();
		
	} // end of main method
	
} // end of AttendanceApp
