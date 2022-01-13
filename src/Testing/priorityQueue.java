package Testing;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class priorityQueue {


    public static void main(String[] args) {

        System.out.println("cpu number:"
                + Runtime.getRuntime().availableProcessors());
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(1);
        priorityQueue.add(32);
        priorityQueue.add(4);
        priorityQueue.add(2);
        priorityQueue.add(3);

        for (Integer p : priorityQueue) {
            System.out.println(p);
        }
        priorityQueue.poll();
        priorityQueue.poll();

        Iterator iterator = priorityQueue.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

    }
}
