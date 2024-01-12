package warmingup.part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Your task is to implement the methods in this class. Use the JUnit test
 * provided to verify that your implementation works as expected. You can also
 * write a main method to test your implementations.
 *
 * Do not change the signatures of the methods already provided. However, you
 * are free to add new methods.
 */
public class CollectionsBasics {

    public static void main(String[] arsg) {
        CollectionsBasics collectionsBasics = new CollectionsBasics();

        // maximum method test
        List<Integer> numList = Arrays.asList(5, 1, 4, 55, 6);
        int highValue = maximum(numList);
        System.out.println("Highest value is " + highValue);

        // sum method test
        List<Integer> sumList = Arrays.asList(5, 1, 4, 55, 6);
        int sumValue = sum(sumList);
        System.out.println("Sum of value is " + sumValue);

        // concatenateStrings method test
        List<String> strList = List.of("orange", "foo", "banana", "bar", "baz");
        String concatenateStrings = collectionsBasics.concatenateStrings(strList);
        System.out.println(concatenateStrings);

        // getLengths
        List<String> strList2 = List.of("Java", "Python", "TypeScript");
        List<Integer> getLengthString = collectionsBasics.getLengths(strList2);
        System.out.println(getLengthString);

    }

    /**
     * Finds the maximum value in a list of integers. You can assume that the list
     * is not empty.
     *
     * @param numbers The list of integers.
     * @return The maximum value in the list.
     */
    public static int maximum(List<Integer> numbers) {
        int highnum = Collections.max(numbers);
        return highnum;
    }

    /**
     * Calculates the sum of all integers in a list.
     *
     * @param numbers The list of integers.
     * @return The sum of all integers in the list.
     */
    public static int sum(List<Integer> numbers) {
        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }

        return sum; // TODO: implement this method
    }

    /**
     * Concatenates (or joins) a list of strings into a single string.
     * For example, if the list contains the strings "foo", "bar" and "baz",
     * the result is "foobarbaz". You can assume that the list is not empty.
     *
     * @param strings The list of strings.
     * @return The concatenated string.
     */
    public String concatenateStrings(List<String> strings) {

        StringBuilder r = new StringBuilder();

        for (String str : strings) {
            r.append(str);
        }
        return r.toString();
        /*
         * for (int i = 0; i < strings.size(); i++) {
         * System.out.println(i + " " + strings);
         * if (strings.get(i).equals("foo") || strings.get(i).equals("bar") ||
         * strings.get(i).equals("baz")) {
         * return "foo";
         * }
         * }
         * 
         * System.out.println(strings);
         * return "";
         */
        // TODO: implement this method
    }

    /**
     * Returns the lengths of the strings in the input list.
     * For example, if the input list contains the strings "Java", "Python" and
     * "TypeScript", the result is a list containing the numbers 4, 6 and 10.
     *
     * @param strings The list of strings.
     * @return A list containing the lengths of the strings in the input list.
     */
    public List<Integer> getLengths(List<String> strings) {
        List<Integer> strLength = new ArrayList<>();
        for (String str : strings) {
            // System.out.println(str.length());
            strLength.add(str.length());
        }
        // System.out.println(strLength);
        return strLength; // TODO: implement this method
    }
}
