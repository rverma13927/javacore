package Testing;


import java.util.Stack;

class Node {
    Node left;
    Node right;
    int value;
    Node(int value){
        this.value=value;
    }
}


public class Bst {
    Node root;
    Bst(){
        root = null;
    }

    public static void main(String[] args) {
         Bst node= new Bst();
         node.root = new Node(5);
         node.root.left = new Node(4);
         node.root.right = new Node(6);
         node.root.left.left = new Node(2);
         node.root.left.right = new Node(112);
         node.root.right.left = new Node(8);
         node.root.right.right = new Node(9);

         /*
                                          5
                                     4              6
                                2        1       8        9
          */
        recursivePreorder(node.root,0);
        System.out.println();
        preorderUsingStack(node.root);
        System.out.println(ans);
    }

    private static void preorderUsingStack(Node node) {

        Stack<Node> stack = new Stack<>();
        stack.push(node);


        while(!stack.empty()){
            Node top = stack.peek();
            System.out.print(top.value + " ");
            stack.pop();
            if(top.right!=null){
                stack.push(top.right);
            }
            if(top.left!=null) {
                stack.push(top.left);
            }
        }

    }
    public static  int ans=0;
    private static void recursivePreorder(Node node,int v) {
        ans = Math.max(ans,v);
        if(node==null)return;
        System.out.print(node.value+ " ");

        recursivePreorder(node.left,v+node.value);
        recursivePreorder(node.right,v+node.value);
    }


}
