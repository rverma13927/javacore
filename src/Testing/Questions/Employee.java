package Testing.Questions;

import java.lang.reflect.Array;
import java.util.*;

/**
 * sort list of emp based on something
 */
public class Employee implements Comparable<Employee>{
    private Integer id;
    private String name;
  private Double salary;
    public Employee(Integer id, String name,Double salary) {
        this.id = id;
        this.name = name;
        this.salary =salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee employee) {
        return this.id- employee.id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}



class Test1{
    public static void main(String[] args) {
         Employee employee = new Employee(1,"Deepak", 1000.0);
         Employee employee2 = new Employee(4,"Mayank", 6000.0);
         Employee employee3 = new Employee(3,"Rahul", 34000.0);

        List<Employee> employees = Arrays.asList(employee,employee2,employee3);

        Collections.sort(employees);

        for (Employee employee1 : employees) {
            System.out.println(employee1.toString());
        }
        System.out.println("Case 2");
        employees.sort((t1,t2)-> (int) (t1.getSalary()- t2.getSalary()));
        for (Employee employee1 : employees) {
            System.out.println(employee1.toString());
        }
        System.out.println("Sorting desc salary");
        employees.sort((t1,t2)-> (int) (t2.getSalary()- t1.getSalary()));
        for (Employee employee1 : employees) {
            System.out.println(employee1.toString());
        }
        employees.sort((t1,t2)-> {
              if(t1.getName().compareTo(t2.getName())>0)return 1;
              return -1;
        });
        System.out.println("Sorting by name");
        for (Employee employee1 : employees) {
            System.out.println(employee1.toString());
        }
    }
}