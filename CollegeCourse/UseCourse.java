import java.util.Scanner;

public class UseCourse {
	private enum labCourses {
		BIO, CHM, CIS, PHY
	};

	private static boolean isLabCourse(String d) {
		for (labCourses c : labCourses.values()) {
			if (c.name().equals(d))
				return true;
		}

		return false;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String userInput;
		String department;
		int courseNumber;
		int creditHours;

		System.out.print("Enter the Department: ");
		userInput = input.nextLine();
		department = userInput.toUpperCase().substring(0, 3);

		System.out.print("Enter the Course Number: ");
		userInput = input.nextLine();
		courseNumber = Integer.parseInt(userInput);

		System.out.print("Enter the number of credit hours: ");
		userInput = input.nextLine();
		creditHours = Integer.parseInt(userInput);

		if (isLabCourse(department)) {
			LabCourse userCourse = new LabCourse(department, courseNumber, creditHours);
			userCourse.display();
		} else {
			CollegeCourse userCourse = new CollegeCourse(department, courseNumber, creditHours);
			userCourse.display();
		}

		input.close();
	}
}