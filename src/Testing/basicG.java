package Testing;

import java.lang.reflect.Array;
import java.util.*;

public class basicG {

    public static void main(String[] args) {
       LinkedList<Integer> graph [] = new LinkedList[5];


       int  size=5;
       for(int i=0;i<5;i++ ) graph[i] = new LinkedList<>();

               /*
                                       1      --------         2




                */



         graph[1].add(2); graph[2].add(1);
         graph[1].add(3);graph[3].add(1);
         graph[2].add(3);graph[3].add(2);
         graph[1].add(4); graph[4].add(1);


//         bfs


        bfs(graph,5);

        System.out.println("----------------------");
        dfs(graph,5);






    }

    private static void dfs(LinkedList<Integer>[] graph, int n) {
        Boolean visited [] = new Boolean[n];
        for(int i=0;i<n;i++) visited[i]=false;
        visited[1] =true;

        Stack<Integer> stack = new Stack<>();
        stack.add(1);


        while(!stack.empty()){
            int cur = stack.pop();
            System.out.println(cur + " ");
            for(int i=0;i< graph[cur].size();i++){
                if(visited[graph[cur].get(i)]==false){
                     visited[graph[cur].get(i)] = true;
                     stack.add(graph[cur].get(i));
                }
            }
        }


    }

    private static void bfs(LinkedList<Integer>[] graph, int n) {

        Boolean visited [] = new Boolean[n];
        for(int i=0;i<n;i++) visited[i]=false;
        visited[1] =true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()){
            int cur = queue.poll();
            System.out.println(cur+ " ");
            for(int i=0;i<graph[cur].size();i++){
                if(visited[graph[cur].get(i)]==false){
                    visited[graph[cur].get(i)] = true;
                    queue.add(graph[cur].get(i));
                }
            }
        }

        Integer ar [ ] = new Integer[2];
        ar[0]=15;
        ar[1]=13;
        Arrays.sort(ar,(a,b)-> a-b);
        System.out.println();
        for(Integer a : ar){
                System.out.println(a);
        }

    }
}


//

class generate{

    public static void main(String[] args) {

           List<String> ans = new ArrayList<>();
           int n =3;
           generatePattern(new StringBuilder(),n, 0,0,ans);
        System.out.println(ans.size());
           for(String a : ans){
               System.out.println(a);
           }
    }

    private static void generatePattern(StringBuilder cur, int n, int l, int r, List<String> ans) {

         if(n*2 == cur.length()){
              ans.add(cur.toString());
             return;
         }

         if(l<n){
             cur.append("(");
             generatePattern(cur,n,l+1,r,ans);
             cur.deleteCharAt(cur.length()-1);
         }
         if(r<l){
             cur.append(")");
             generatePattern(cur,n,l,r+1,ans);
             cur.deleteCharAt(cur.length()-1);
         }

    }




}
class test{
    public static void main(String[] args) {

        int m=3;
        int n=7;


        System.out.println( solve(m,n,0,0));





    }

    private static  int  solve(int m, int n, int r, int c) {
          if(r>=m || c>=n) return 0;
          if(r==m-1 && c==n-1) return 1;
          return solve(m,n,r+1,c) + solve(m,n,r,c+1);
    }
}


//synchronized keyword
class Table
{
    void printTable(int n){
        synchronized(this){//synchronized block
            for(int i=1;i<=5;i++){
                System.out.println(n*i + " "+ Thread.currentThread().getName());
                try{
                    Thread.sleep(400);
                }catch(Exception e){System.out.println(e);}
            }
        }
    }//end of the method
}

class MyThread1 extends Thread{
    Table t;
    MyThread1(Table t){
        this.t=t;
    }
    public void run(){
        t.printTable(5);
    }

}
class MyThread2 extends Thread{
    Table t;
    MyThread2(Table t){
        this.t=t;
    }
    public void run(){
        t.printTable(100);
    }
}

 class TestSynchronizedBlock1{
    public static void main(String args[]){
        Table obj = new Table();//only one object
        MyThread1 t1=new MyThread1(obj);
        MyThread2 t2=new MyThread2(obj);
        t1.start();
        t2.start();
    }
}

class GG{
    String s;
    String pp;

    public GG(String s, String pp) {
        this.s = s;
        this.pp = pp;
    }
}

 class Tesrsrt {
//     static


    public static void main(String[] args)
    {
        String s1 = "HELLO";
        String s2 = "HELLO";
        String s3 =  new String("HELLO");
        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); // false
        System.out.println(s1.equals(s2)); // true
        System.out.println(s1.equals(s3)); // true


        GG g = new GG("a","b");
        GG g1 = g;
        System.out.println(g.equals(g1));
        System.out.println(g==(g1));

        String str= "1";
        if(str.contains(":")){
            System.out.println(str.split(":")[0]);
        }else{
            System.out.println(str);
        }
    }
}

 class TestFinallyBlock1{
    public static void main(String args[]){

        try {

            System.out.println("Inside the try block");

            //below code throws divide by zero exception
            int data=25/0;
            System.out.println(data);
        }
        //cannot handle Arithmetic type exception
        //can only accept Null Pointer type exception
        catch(NullPointerException e){
            System.out.println(e);
        }

        //executes regardless of exception occured or not
        finally {
            System.out.println("finally block is always executed");
        }

        System.out.println("rest of the code...");
    }
}


 class TestThrowAndThrows
{
    // defining a user-defined method
    // which throws ArithmeticException
    static void method()
    {
        System.out.println("Inside the method()");
//        throw new Exception();
        throw new ArithmeticException("throwing ArithmeticException");
    }
    //main method
    public static void main(String args[])
    {
        try
        {
            method();
        }
        catch(ArithmeticException e)
        {
            System.out.println("caught in main() method");
        }
    }
}
