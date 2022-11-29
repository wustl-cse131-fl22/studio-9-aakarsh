package studio9;

import assignment7.Student;
import java.util.Map;
import java.util.HashMap;

public class UniversityDatabase {
	private final Map<String,Student> name = new HashMap<String,Student>();
	//TODO: Complete this class according to the studio instructions

	public void addStudent(String accountName, Student student) {
		name.put(accountName, student);
	}

	public int getStudentCount() {
		int count = name.size();
		return count;
	}

	public String lookupFullName(String accountName) {
		if (name.containsKey(accountName)) {
			return name.get(accountName).getFullName();
		}
		else {
			return null;
		}
	}

	public double getTotalBearBucks() {
		double bucks = 0.0;
		for (String student: name.keySet()) {
			bucks = bucks + name.get(student).getBearBucksBalance();
		}
		return bucks;
	}
}
