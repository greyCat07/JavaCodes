public class LabCourse extends CollegeCourse {
	private final double LAB_FEE = 50.00;

	private double labCourseFee;

	public LabCourse(String d, int cn, int cr) {
		super(d, cn, cr);

		this.calculateFee();
	}

	private void calculateFee() {
		labCourseFee = super.getFee() + LAB_FEE;
	}

	public void display() {
		System.out.println("\n== Lab Course ==");
		System.out.println("Department: " + getDepartment());
		System.out.println("Course Num: " + getCourseNumber());
		System.out.println("Credit Hrs: " + getCredits());
		System.out.println("Course Fee: " + labCourseFee);
		System.out.println("Lab Fee of $" + LAB_FEE + " applied");
	}
}