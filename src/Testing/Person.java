package Testing;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public class Person {


    private Integer id;
    private String name;
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(name, person.name) ;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public Person(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Person() {
    }
}

class a{


    public static void main(String[] args) {
        HashMap<Person,String> hashMap = new HashMap<>();


        Person person = new Person(1,"d","r");
        Person person2 = new Person(1,"dd","r");
        Person person3 = new Person(1,"d","rr");


        Person person4 = new Person(2,"d","rrr");


        /*

          sabse pahle person ko put kiya
          then person2 ke liye hashcode or index same hoga toh ab wo check karega ki equal hai ki nhi objects
          if equal hai toh replace kar dega jo ki equal method par depend karega ki kaise likha hai, yadi simple id se equal check kar rahe toh replace kar dega data
          equal nhi hai toh linkedlist mein add kar dega
          if linkedlist ki size 8 se jayda hoti hai toh wo balanced binay tree mein convert kar dega
         */

        hashMap.put(person,"cse");
        hashMap.put(person2,"mech");
        hashMap.put(person3,"meta");
        hashMap.put(person4,"civil");
        System.out.println(person.equals(person2)+ "       dff");
        System.out.println(hashMap.size());
       for(Map.Entry entry : hashMap.entrySet()){
           System.out.println(entry.getKey() + " " + entry.getValue());
       }
    }
}
