package Testing;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Linkedlist1 {


    public static void main(String[] args) {
        LinkedList<Integer> linkedlist = new LinkedList<>();


        linkedlist.add(213);
        linkedlist.add(3213);
        linkedlist.add(4213);
        linkedlist.add(5213);

        for(Integer a : linkedlist){
            System.out.print(a+ " ");
        }


        linkedlist.remove();
        linkedlist.remove();
        linkedlist.remove();
        System.out.println();
        for(Integer a : linkedlist){
            System.out.print(a+ " ");
        }






    }
}



class deque{


    public static void main(String[] args) {
        Deque<String> deque=new ArrayDeque<String>();

        deque.offer("arvind");
        deque.offer("vimal");
        deque.add("mukul");
        deque.offerFirst("jai");
        System.out.println("After offerFirst Traversal...");
        for(String s:deque){
            System.out.println(s);
        }
        //deque.poll();
        //deque.pollFirst();//it is same as poll()
        deque.pollLast();
        System.out.println("After pollLast() Traversal...");
        for(String s:deque){
            System.out.println(s);
        }



    }
}
