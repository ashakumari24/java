public class 	pra1 {
// Print Number in increasing order
 public static void printInc(int n)
 {
    if (n==1) {
        System.out.println(n);
        return;
    }
    printInc(n-1);
    System.out.println(n);
 }
 // To print values in decreasing order
 public static void printDec(int n)
 {
    if (n==1) {
        System.out.println(1);
        return;
    }
    System.out.println(n);
    printDec(n-1);
 }
 // To find factorial of Given Number
 public static int factorial(int n)
 {
    if (n==1) {
        return 1;
    }
    return n*factorial(n-1);
 }
 // To find Sum of natural number
 public static int SumOfNaturalNo(int n)
 {
    if (n==1) {
        return 1;
    }
    return n+SumOfNaturalNo(n-1);
 }
 // To find Nth number Fabinacci Number
 public static int Fabinacci(int n)
 {
    if (n==0 || n==1) {
        return n;
    }
    return Fabinacci(n-1)+Fabinacci(n-2);
 }
public static void main (String[] args) {
    // int n=10;
    // printDec(n);
    // printInc(n);
    // System.out.println(factorial(n));
    // System.out.println(SumOfNaturalNo(n));
    // System.out.println(Fabinacci(n));
}
}