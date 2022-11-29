package studio9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import support.cse131.NotYetImplementedException;

public class NameToHeight {
	/**
	 * Construct and fill a map with your studio group members' names, each
	 * associated with his or her height.
	 * 
	 * Construct an ArgsProcessor and loop asking the args processor for a name to
	 * lookup the height. When the user cancels (that is: when args processor
	 * returns null), break from the loop. Otherwise, loop up the name in the map
	 * and output the results. Be sure to handle the case where the map does not
	 * contain a specified name.
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Map <String, Double> nameToHeight = new HashMap<String, Double>();
		nameToHeight.put("Aakarsh", 72.0);
		nameToHeight.put("Arjun", 69.0);
		nameToHeight.put("Anthony", 74.0);
		nameToHeight.put("Aidan", 76.0);
		for (int i = 0; i < nameToHeight.size(); i++) {
			System.out.println("Please enter name");
			String name = in.next();
			System.out.println(nameToHeight.get(name));
		}

	}
}
