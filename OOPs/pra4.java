public class 	pra4 {
public static void main (String[] args) {
    Horse h1=new Horse();
    h1.eat();
    h1.walk();
    System.out.println(h1.color);
}
}
abstract class Animal{
    String color;
    Animal()
    {
        color="Brown";
    }
    void eat(){
        System.out.println("Animal eats");
    }
    abstract void walk();
}
class Horse extends Animal{
    void changecolor()
    {
        color="dark brown";
    }
    void walk()
    {
        System.out.println("Walk on 4 legs");
    }
}