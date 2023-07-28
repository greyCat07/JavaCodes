public class CollegeCourse {
	private String department;
	private int courseNumber;
	private int credits;
	private double fee;

	// Some extras
	private final double COST_PER_CREDIT_HOUR = 120.00;

	public CollegeCourse(String d, int cn, int cr) {
		department = d.toUpperCase();
		courseNumber = cn;
		credits = cr;

		calculateFee();
	}

	public String getDepartment() {
		return department;
	}

	public int getCourseNumber() {
		return courseNumber;
	}

	public int getCredits() {
		return credits;
	}

	public double getFee() {
		return fee;
	}

	private void calculateFee() {
		fee = COST_PER_CREDIT_HOUR * credits;
	}

	public void display() {
		System.out.println("\n****** Course ******");
		System.out.println("Department: " + department);
		System.out.println("Course Num: " + courseNumber);
		System.out.println("Credit Hrs: " + credits);
		System.out.println("Course Fee: " + fee);
	}
}