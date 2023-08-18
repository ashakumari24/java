public class 	pra3 {
public static void main (String[] args) {
    bird b1=new bird();
    b1.eat();
}
}
// Base class
class Animal{
    String color;
    void eat()
    {
        System.out.println("Eating");
    }
    void breath()
    {
        System.out.println("Breath");
    }
}
// Derived Class
class Fish extends Animal
{
  int fins;

}
// multilevel inheritance
class bird extends Fish{
   int leg;
}
