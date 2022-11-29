package assignment7;

//TODO: Copy a working Student class from Assignment 7 over this file.
public class Student {
	private String firstName;
	private String lastName;
	private int idNum;
	private int attemptCred;
	private int passCred;
	private double totalGradeQualityPoints;
	private double bearBucks;
	
	/*
	 * parameters are the student's first name, the student's last name, and the student's id number
	 * method sets the instance variables first name, last name, and id number to the given parameters
	 */
	public Student(String firstName, String lastName, int id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNum = id;
	}
	
	/*
	 * parameters are the students grade ranging from 0 to 4 and the number of credits for a course
	 * Method adds the credits for a course to the number of attempted credits. If the student had a grade over 1.7, the number of credits was also added to the students grade.
	 * Method also calculated the total grade quality points earned from this grade using the credits earned from the class and the students grade. It then added this value to the students total quality credits.
	 */
	public void submitGrade(double grade, int credits) {
		this.attemptCred += credits;
		if (grade >= 1.7) {
			this.passCred += credits;
		}
		this.totalGradeQualityPoints += (credits * grade);
	}
	
	/*
	 * returns the full name of the student
	 */
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}
	
	/*
	 * returns the student's ID
	 */
	public int getId() {
		return this.idNum;
	}
	
	/*
	 * returns the student's attempted credits
	 */
	public int getAttemptedCredits() {
		return this.attemptCred;
	}
	
	/*
	 * returns the student's passed credits
	 */
	public int getPassingCredits() {
		return this.passCred;
	}
	
	/*
	 * returns the GPA of the student
	 */
	public double calculateGradePointAverage() {
		return (this.totalGradeQualityPoints/this.attemptCred);
	}
	
	/*
	 * method checks to see how many credits the student has passed and assigns them a ranking based on that value
	 * returns the ranking of that student
	 */
	public String getClassStanding() {
		if (passCred >= 90) {
			return "Senior";
		}
		else if (passCred >= 60) {
			return "Junior";
		}
		else if (passCred >= 30) {
			return "Sophomore";
		}
		else {
			return "First Year";
		}
	}
	
	/*
	 * method checks to see if the student has the right GPA and passed credits to enter PhiBetaKappa
	 * returns if the student can enter PhiBetaKappa
	 */
	public boolean isEligibleForPhiBetaKappa() {
		if (calculateGradePointAverage() >= 3.60 && passCred >= 98 || (calculateGradePointAverage() >= 3.80 && passCred >= 75)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/*
	 * parameter is the amount of bear bucks added to the student's account
	 * method adds the chosen amount of bear bucks to the student's total bear bucks
	 */
	public void depositBearBucks(double amount) {
		this.bearBucks += amount;
	}
	
	/*
	 * parameter is the amount of bear bucks to be removed from the student's account
	 * method removes the chosen amount of bear bucks from the student's total account
	 */
	public void deductBearBucks(double amount) {
		this.bearBucks -= amount;
	}
	
	/*
	 * returns the student's total bear bucks
	 */
	public double getBearBucksBalance() {
		return this.bearBucks;
	}
	
	/*
	 * method "cashes out" the student's bear bucks and removes them from the student's account after a service fee
	 * returns the amount of dollars recieved after the student has cashed out their account
	 */
	public double cashOutBearBucks() {
		if (this.bearBucks >= 10) {
			double amountCashOut = this.bearBucks - 10.0;
			this.bearBucks = 0.00;
			return amountCashOut;
		}
		else {
			this.bearBucks = 0.00;
			return 0.0;
		}
	}
	
	/*
	 * parameters are the legacy student's first name, their other parent's student status, if their last name is a hyphenated version of their parents' last names, and the new student's id
	 * method creates the new student using the given parameters and deposits their parent's bear bucks into their account after cashing out their parent's remaining bear bucks
	 * returns the legacy student
	 */
	public Student createLegacy(String firstName, Student other, boolean isHyphenated, int id) {
		double parent1 = this.cashOutBearBucks();
		double parent2 = other.cashOutBearBucks();
		if (isHyphenated == true) {
			Student legacy = new Student(firstName, this.lastName + "-" + other.lastName, id);
			legacy.depositBearBucks(parent2 + parent1);
			return legacy;
		}
		else {
			Student legacy = new Student(firstName, this.lastName, id);
			legacy.depositBearBucks(parent2 + parent1);
			return legacy;
		}
	}
	
	/*
	 * returns the full name of the student and their id
	 */
	public String toString() {
		return "Name: " + this.firstName + " " + this.lastName + "	ID: " + this.idNum;
	}
}
