package Testing.Questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * https://dzone.com/articles/performance-with-java8-streams
 * https://www.baeldung.com/java-when-to-use-parallel-stream
 * https://www.geeksforgeeks.org/what-is-java-parallel-streams/
 *
 * https://java2blog.com/java-8-parallel-stream/
 * https://javaconceptoftheday.com/java-8-stream-intermediate-and-terminal-operations/
 *
 * https://www.youtube.com/watch?v=Ud0zfImgbYw - abstract vs interface
 * https://stackoverflow.com/questions/10750791/what-is-the-sense-of-final-arraylist
 */
public class PerformanceOfStream {

    public static void main(String[] args) {
        //Calculating square root of even numbers from 1 to N
        int min = 1;
        int max = 1000000;

        List<Integer> sourceList = new ArrayList<>();
        for (int i = min; i < max; i++) {
            sourceList.add(i);
        }

        List<Double> result = new LinkedList<>();


        //Collections approach
        long t0 = System.nanoTime();
        long elapsed = 0;
        for (Integer i : sourceList) {
            if (i % 2 == 0) {
                result.add(Math.sqrt(i));
            }
        }
        elapsed = System.nanoTime() - t0;
        System.out.printf("Collections: Elapsed time:\t %d ns \t(%f seconds)%n", elapsed, elapsed / Math.pow(10, 9));


        //Stream approach
        Stream<Integer> stream = sourceList.stream();
        t0 = System.nanoTime();
        result = stream.filter(i -> i % 2 == 0).map(i -> Math.sqrt(i)).collect(Collectors.toList());
        elapsed = System.nanoTime() - t0;
        System.out.printf("Streams: Elapsed time:\t\t %d ns \t(%f seconds)%n", elapsed, elapsed / Math.pow(10, 9));


        //Parallel stream approach
        stream = sourceList.stream().parallel();
        t0 = System.nanoTime();
        result = stream.filter(i -> i % 2 == 0).map(i -> Math.sqrt(i)).collect(Collectors.toList());
        elapsed = System.nanoTime() - t0;

        result.forEach(e-> System.out.println(e));
        System.out.printf("Parallel streams: Elapsed time:\t %d ns \t(%f seconds)%n", elapsed, elapsed / Math.pow(10, 9));

        final List<String> list = new ArrayList<String>();
        list.add("sdsd");
        final List fixedList = Collections.unmodifiableList(list);
//       @Throws UnsupportedOperationException
//        fixedList.add("fd");


    }
}