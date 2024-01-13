package main.java.part2;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * This class demonstrates how Stream operations handle situations where there
 * is no value to return. For example, if you try to get the maximum value of an
 * empty stream, there is no maximum value to return. In this case, the
 * operation returns a special value called OptionalDouble, which may or may not
 * contain a value.
 */
public class OptionalValues {

    public static void main(String[] args) {

        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);

        OptionalValues ov = new OptionalValues();

        // Test the maximum method
        double maxResult = ov.maximum(intStream);
        System.out.println("Maximum: " + maxResult);

        // Create a new IntStream for the average method
        IntStream anotherStream = IntStream.of(2, 4, 6, 8, 10);
        double averageResult = ov.average(anotherStream);
        System.out.println("Average: " + averageResult);
    }

    /**
     * Returns the average of integers in the specified IntStream. If the stream is
     * empty, returns 0.0.
     *
     * @param stream the IntStream to average
     * @return the average of the numbers in the stream or 0 if the stream is empty
     */
    public double average(IntStream stream) {
        /*
         * See the `average()` method in the documentation of IntStream. Note that the
         * stream may be empty, so there may not be an average value. That is why the
         * method returns a special type called OptionalDouble.
         *
         * You can check if the OptionalDouble is empty by calling the `isPresent()`
         * method. Another approach is to use the `orElse()` method, which returns the
         * actual value if it is present, or an alternative value if the OptionalDouble
         * is empty.
         */

        OptionalDouble average = stream.average();

        return average.orElse(0.0); // TODO
    }

    /**
     * Returns the maximum value of integers in the specified IntStream. If the
     * stream is empty, returns 0.
     *
     * @param stream the IntStream to get the maximum value from
     * @return the maximum value in the stream or 0 if the stream is empty
     */
    public double maximum(IntStream stream) {
        OptionalInt max = stream.max();
        return max.orElse(0);
    }
}
