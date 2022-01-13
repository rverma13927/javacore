package Testing;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test {


    public static void main(String[] args) {

                long startTime = System.currentTimeMillis();


       Runnable thread = () -> {
            try {
                FileWriter fileWriter = new FileWriter("/home/beehyv/a");

                for(int i=0;i<1000000;i++) {
//                    System.out.println("writing to fileeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
                    fileWriter.write(i+1+ "Files in Java might be tricky, but it is fun enough!\n");
                }
                fileWriter.close();
//                for(int i=0;i<100000;i++)
//                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
       };


        Runnable thread2 = () -> {
            try {
                FileReader fileReader = new FileReader("/home/beehyv/a");

                int i;
                while ((i = fileReader.read()) != -1) {
//                    System.out.println("reading to filyuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
                    System.out.print((char) i);
                }
                fileReader.close();
            } catch (IOException e) {
                System.out.println("An error occurred. while reading");
                e.printStackTrace();
            }
        };


        Runnable thread3 = () -> {
            try {
                FileReader fileReader = new FileReader("/home/beehyv/a");

                int i;
                while ((i = fileReader.read()) != -1) {
//                    System.out.println("reading to filyuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
                    System.out.print((char) i);
                }
                fileReader.close();
            } catch (IOException e) {
                System.out.println("An error occurred. while reading");
                e.printStackTrace();
            }
        };
        Runnable thread4 = () -> {
            try {
                FileReader fileReader = new FileReader("/home/beehyv/a");

                int i;
                while ((i = fileReader.read()) != -1) {
//                    System.out.println("reading to filyuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
                    System.out.print((char) i);
                }
                fileReader.close();
            } catch (IOException e) {
                System.out.println("An error occurred. while reading");
                e.printStackTrace();
            }
        };
        thread.run();
        thread2.run();
        thread3.run();
        thread4.run();
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
    }


}

//abstract
abstract class Bike{
    Bike(){System.out.println("bike is created");}
    abstract void run();
    void changeGear(){System.out.println("gear changed");}
}
//Creating a Child class which inherits Abstract class
class Honda extends Bike{
    void run(){System.out.println("running safely..");}
//    void changeGear(){System.out.println("gear changed in honda");}
}
//Creating a Test class which calls abstract and non-abstract methods
class TestAbstraction2{
    public static void main(String args[]){
        Bike obj = new Honda();
        obj.run();
        obj.changeGear();
    }
}

//

interface A{
    void a();
    void b();
    void c();
    void d();
}

abstract class B implements A{
    public void c(){System.out.println("I am c");}
}

class M extends B{
    public void a(){System.out.println("I am a");}
    public void b(){System.out.println("I am b");}
    public void d(){System.out.println("I am d");}
}

class Test5{
    public static void main(String args[]){
        A a=new M();
        a.a();
        a.b();
        a.c();
        a.d();
    }}


class testing11{
    public static void main(String[] args) {
        String home = System.getProperty("user.home");
        System.out.println(home+"/LabReports");  // prints the path to your home directory
        File file = new File(home);
        System.out.println(file.exists());
    }
}

