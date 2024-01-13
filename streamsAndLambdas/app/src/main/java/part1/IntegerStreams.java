package part1;

import java.util.stream.IntStream;

public class IntegerStreams {

    public static void main(String[] args) {

        IntegerStreams integerStreams = new IntegerStreams();

        // Define the range
        int from = 1;
        int to = 10;

        integerStreams.numbersBetween(from, to)
                .forEach(System.out::println);
    }

    /**
     * Generates an inclusive range of integer numbers between the specified 'from'
     * and 'to' values.
     *
     * @param from the starting value (inclusive) of the range
     * @param to   the ending value (inclusive) of the range
     * @return an IntStream containing the numbers between 'from' and 'to'
     *         (inclusive)
     */
    public IntStream numbersBetween(int from, int to) {
        /*
         * hint: see the documentation of IntStream about how to create a range of
         * numbers. A closed range means that the 'to' value is included in the range,
         * whereas an open range does not include the 'to' value.
         */
        return IntStream.rangeClosed(from, to); // TODO
    }

    /**
     * Returns the sum of integers in the specified IntStream.
     *
     * @param stream the IntStream to sum
     * @return the sum of the numbers in the stream
     */
    public int sum(IntStream stream) {
        /*
         * hint: see the documentation of IntStream about how to get the sum of the
         * numbers in a stream.
         */
        return stream.sum(); // TODO
    }

    /**
     * Returns the number of values in the specified IntStream. As the number of
     * values may be larger than the int type can represent, the return type is
     * long. You can assume that the stream is not infinite, although infinite
     * streams are possible in Java.
     *
     * @param stream the IntStream to count
     * @return the number of values in the stream (which may be over
     *         Integer.MAX_VALUE)
     */
    public long countNumbersInStream(IntStream stream) {
        /*
         * hint: see the documentation of IntStream about how to count the number of
         * elements in the stream.
         */
        return stream.count(); // TODO
    }
}
