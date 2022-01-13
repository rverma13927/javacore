package Testing;

//public class MUltipleInheritanc {
//}


// Java program to demonstrate Multiple Inheritance
// through default methods

// Interface 1
interface PI1 {

    // Default method
    default void show()
    {

        // Print statement if method is called
        // from interface 1
        System.out.println("Default PI1");
    }
}

// Interface 2
interface PI2 extends  PI1{

    // Default method
    default void show()
    {

        // Print statement if method is called
        // from interface 2
        System.out.println("Default PI2");
    }
}

// Main class
// Implementation class code
public class MUltipleInheritanc implements PI1, PI2 {

    // Overriding default show method


    // Mai driver method
    public static void main(String args[])
    {

        // Creating object of this class in main() method
        MUltipleInheritanc d = new MUltipleInheritanc();
        d.show();
    }


}
