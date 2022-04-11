package Testing.practiceJava8;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Practice {
    public static void main(String[] args) {

/**
 * Let me show you the power of the stream API with an example. Say,
 * the task is to group an array of employee records into a data map organized by job title.
 * Here is a traditional way to loop through the list and construct a data map.
 *
 * public Map<String, List<Employee>> groupByJobTitle(List<Employee> employeeList) {
 *   Map<String, List<Employee>> resultMap = new HashMap<>();
 *   for (int i = 0; i < employeeList.size(); i++) {
 *       Employee employee = employeeList.get(i);
 *       List<Employee> employeeSubList = resultMap.getOrDefault(employee.getTitle(), new ArrayList<Employee>());
 *       employeeSubList.add(employee);
 *       resultMap.put(employee.getTitle(), employeeSubList);
 *   }
 *   return resultMap;
 * }
 *
 */
        List<Employee> list = Arrays.asList(new Employee("SDE1", (double) 900000l), new Employee("SDE1", (double) 800000l),
                new Employee("SDE2", (double) 1000000l), new Employee("SDE2", (double) 1500000l),
                new Employee("SDE3", (double) 1900000l));

        Map<String, List<Employee>> stringListMap = groupByJobTitle(list);
        stringListMap.forEach((i, j) -> {
            System.out.print(i + " -");
            j.forEach(k -> System.out.print(k.getSalary() + " "));
            System.out.println();
        });
// avg salary
        double asDouble = list.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
        System.out.println(asDouble);

        /**
         *  increase salary by 10% to all the employee of all sde1
         */

        list.stream().filter(r -> r.getTitle().equals("SDE1")).forEach(e -> e.setSalary(e.getSalary() + e.getSalary() * 0.1));

        list.forEach(e -> System.out.println(e.getTitle() + " " + e.getSalary()));

        list.stream().sorted(Comparator.comparing(Employee::getSalary));
        System.out.println("Sorted");
        list.forEach(e -> System.out.println(e.getTitle() + " " + e.getSalary()));

        list.stream().filter(r -> r.getTitle().equals("SDE1")).forEach(e -> e.setSalary((double) 0l));
        list.forEach(e -> System.out.println(e.getTitle() + " " + e.getSalary()));

        /**
         *
         *
         *
         * List<String> list = Arrays.asList("John", "Mark", "Robert", "Lucas", "Brandon");
         * List<String> sortedList = list.stream()
         *         .sorted(Collections.reverseOrder())
         *         .collect(Collectors.toList());
         *
         * System.out.println(sortedList);
         */

        List<String> list2 = Arrays.asList("John", "Mark", "Robert", "Lucas", "Brandon");
        List<String> sortedList = list2.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(sortedList);
        Stream<String> sorted = list2.stream().sorted(String::compareTo);
        sorted.forEach(e -> System.out.println(e));


        // sort by age and in reverse
        List<User> userList = new ArrayList<>(Arrays.asList(
                new User("John", 33),
                new User("Robert", 26),
                new User("Mark", 26),
                new User("Brandon", 42)));

        List<User> sortedList2 = userList.stream()
                .sorted(Comparator.comparingInt(User::getAge))
                .collect(Collectors.toList());

        sortedList2.forEach(System.out::println);
//reverse
        List<User> sortedList3 = userList.stream()
                .sorted(Comparator.comparingInt(User::getAge).reversed())
                .collect(Collectors.toList());

        sortedList3.forEach(System.out::println);

        System.out.println("Sorted 4");
        List<User> sortedList4 = userList.stream()
                .sorted((o1, o2) -> {
                    if(o1.getAge() == o2.getAge())
                        return o1.getName().compareTo(o2.getName());
                    else if(o1.getAge() > o2.getAge())
                        return 1;
                    else return -1;
                })
                .collect(Collectors.toList());

        sortedList4.forEach(System.out::println);

        /**
         * Java: Finding Duplicate Elements in a Stream
         *
         * Ilkyaz Altuntas
         * https://stackabuse.com/java-finding-duplicate-elements-in-a-stream/
         */



        Stream<String> stream = Stream.of("john", "doe", "doe", "tom", "john");

        Set<String> items = new HashSet<>();
        stream.filter(e-> !items.add(e)).collect(Collectors.toSet()).forEach(System.out::println);


        /**
         * https://www.educative.io/edpresso/how-to-calculate-a-frequency-map-in-java-8p
         */
        List<Integer> list3 = Arrays.asList(9, 2, 2, 7, 6, 6, 5, 7);
//        list3.stream().collect(Collectors.toMap(Function.identity(), value->1,Integer::sum));
        System.out.println(frequencyMap(list3.stream()));
        list3.stream().distinct().forEach(System.out::println);

        /**
         * https://stackabuse.com/java-finding-duplicate-elements-in-a-stream/
         */
        List<String> list4 = new ArrayList(Arrays.asList("A", "B", "C", "D", "A", "B", "C", "A", "F", "C"));

        List<String> distinctElementList = list4.stream()
                .distinct()
                .collect(Collectors.toList());
        distinctElementList.forEach(System.out::println);

        /**
         * https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html
         */

    }

    private static Map<Integer, Long> frequencyMap(Stream<Integer> stream) {
        return stream.collect(
                Collectors.groupingBy(e->e,
                        Collectors.counting()
                )
        );
    }

    public static Map<String, List<Employee>> groupByJobTitle(List<Employee> employeeList) {
        employeeList.stream().collect(Collectors.groupingBy(employee -> employee.getTitle()));
        return employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getTitle));
    }
}
