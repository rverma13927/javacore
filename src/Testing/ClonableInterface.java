package Testing;
import java.lang.Cloneable;


// By implementing Cloneable interface
// we make sure that instances of class ClonableInterface
// can be cloned.
class Ni {
     String s;
     Ni (){

     }
     Ni(String p){
         s=p;
     }
}
class ClonableInterface implements Cloneable {
    int i;
    String s;
    Ni ni;

    // A class constructor
    public ClonableInterface(int i, String s,Ni ni)
    {
        this.i = i;
        this.s = s;
        this.ni =ni;
    }

    // Overriding clone() method
    // by simply calling Object class
    // clone() method.
    @Override
    protected Object clone()
            throws CloneNotSupportedException
    {
        return super.clone();
    }
}

 class Test12 {
    public static void main(String[] args)
            throws CloneNotSupportedException
    {
         Ni ni= new Ni();
         ni.s="pp";
        ClonableInterface a = new ClonableInterface(20, "GeeksForGeeks",ni);

        // cloning 'a' and holding
        // new cloned object reference in b

        // down-casting as clone() return type is Object
        ClonableInterface b = (ClonableInterface)a.clone();

        System.out.println(b.i);
        a.ni=new Ni("oo");
        System.out.println(b.ni.s);
        System.out.println(a.ni.s);




    }
}


// shallow cpoy using cloneable interface
class Aa implements Cloneable{
    public int y;
    public Bb b;

    public Aa(){
        b = new Bb();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException{
        Aa a = new Aa();
        Aa a2 = (Aa) a.clone();
        System.out.print(a.b==a2.b);
    }

}
class Bb {}