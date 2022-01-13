package Testing;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class THres {


    public static void main(String[] args) {


        long startTime = System.currentTimeMillis();


//       Runnable thread = new Runnable() {
//           @Override
//           public void run() {
               try {
                   FileWriter fileWriter = new FileWriter("/home/beehyv/a");

                   for(int i=0;i<1000000;i++) {
                       fileWriter.write(i+1+ "Files in Java might be tricky, but it is fun enough!\n");
                   }
                   fileWriter.close();
//                   for(int i=0;i<1000000;i++)
//                   System.out.println("Successfully wrote to the file.");
               } catch (IOException e) {
                   System.out.println("An error occurred.");
                   e.printStackTrace();
               }
//           }
//       };



//        Runnable thread2 = new Runnable() {
//            @Override
//            public void run() {
                try {
                    FileReader fileReader = new FileReader("/home/beehyv/a");

                    int i;
                    while((i=fileReader.read())!=-1)
                        System.out.print((char)i);
                    fileReader.close();
                } catch (IOException e) {
                    System.out.println("An error occurred. while reading");
                    e.printStackTrace();
                }

        try {
            FileReader fileReader = new FileReader("/home/beehyv/a");

            int i;
            while((i=fileReader.read())!=-1)
                System.out.print((char)i);
            fileReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred. while reading");
            e.printStackTrace();
        }
//            }

        try {
            FileReader fileReader = new FileReader("/home/beehyv/a");

            int i;
            while((i=fileReader.read())!=-1)
                System.out.print((char)i);
            fileReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred. while reading");
            e.printStackTrace();
        }
//            }


//            }
//        };
//        thread.run();
//        thread2.run();
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
    }
//255237

}
