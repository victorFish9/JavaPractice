package warmingup.part3;

import java.util.ArrayList;
import java.util.List;

/**
 * First, implement the missing parts in Person class. Then, implement the
 * methods in this class.
 *
 * You can use the JUnit test provided to verify that your implementation works
 * as expected. You can also write a main method to test your implementations.
 */
public class ObjectExercise {

    /**
     * Generates a formatted string from a list of Person objects, representing
     * their names. This method takes a list of Person objects and generates a
     * string that represents the names of the people in the list.
     *
     * The formatting of the resulting string depends on the number of people in the
     * list:
     *
     * - If the list is empty, an empty string is returned.
     * - If the list contains only one person, their name is returned ("Rachel").
     * - If the list contains two people, their names are joined with "and" in
     * between ("Rachel and Monica").
     * - If the list contains three people, all names are included and a comma is
     * used between first two names ("Rachel, Monica and Ross")
     * - If the list contains more than three people, the names of the first two
     * people are listed, followed by "and X others", where X is the number of
     * remaining people ("Rachel, Monica and 4 others").
     *
     * @param people A list of Person objects to generate the names string from.
     * @return A formatted string representing the names of people in the list.
     */
    public static void main(String[] arsg) {
        List<Person> peopleList = new ArrayList<>();
        peopleList.add(new Person("Victor", 20));
        peopleList.add(new Person("Andrei", 21));
        peopleList.add(new Person("Alisa", 19));
        peopleList.add(new Person("Max", 13));

        String nameList = generateNamesString(peopleList);
        System.out.println("Name list: " + nameList);

    }

    public static String generateNamesString(List<Person> people) {

        if (people == null || people.isEmpty()) {
            return "";
        } else if (people.size() == 1) {
            return people.get(0).getName();
        } else if (people.size() == 2) {
            return people.get(0).getName() + " and " + people.get(1).getName();
        } else if (people.size() == 3) {
            return people.get(0).getName() + ", " + people.get(1).getName() + " and " + people.get(2).getName();
        } else {
            return people.get(0).getName() + ", " + people.get(1).getName() + " and " + (people.size() - 2) + " others";
        }

        // NOTE! The People class needs fixing too. Make sure that the Person class is
        // complete before implementing this method.
        /*
         * StringBuilder result = new StringBuilder();
         * 
         * for (Person p : people) {
         * if (result.length() > 0 && result.length() <= 3) {
         * 
         * result.append(", ");
         * }
         * result.append(p.getName());
         * }
         * System.out.println(result);
         * 
         * return result.toString();
         */

    }
}
