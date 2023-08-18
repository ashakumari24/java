// Constructors
public class pra2 {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Asha";
        s1.roll = 65;
        s1.password = "asdfgh";
        s1.marks[0] = 100;
        s1.marks[1] = 90;
        s1.marks[2] = 75;
        Student S2 = new Student(s1);
        S2.password = "pouiy";
        s1.marks[2] = 98;
        for (int i = 0; i < 3; i++) {
            System.out.println(S2.marks[i]);
        }

    }
}

class Student {
    int roll;
    String name;
    String password;
    int marks[];

    // Non parameterized Constructor
    Student() {
        marks = new int[3];
    }

    // Parameterized Constructor
    Student(int r) {
        this.roll = r;
    }

    // Shallow Copy Constructor
    // Student(Student S)
    // {
    // marks=new int[3];
    // this.roll=S.roll;
    // this.name=S.name;
    // this.marks=S.marks;
    // }
    // Deep Copy Constructor
    Student(Student S) {
        marks = new int[3];
        this.roll = S.roll;
        this.name = S.name;
        for (int i = 0; i < marks.length; i++) {
            this.marks[i] = S.marks[i];
        }
    }
}