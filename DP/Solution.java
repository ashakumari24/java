public class Solution {
    public static void main(String[] args) {
        Cube c1 = new Cube();
        c1.valume();
        c1.area();
        c1.display();

    }
}

class Shape {
    public static void display() {
        System.out.println("inside display  ");
    }
}

class Rectangle extends Shape {
    public static void area() {
        System.out.println("Inside area");
    }
}

class Cube extends Rectangle {
    public static void valume() {
        System.out.println("Inside valume");
    }
}