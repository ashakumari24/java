import java.util.*;
public class pra4 {
public static void main (String[] args) {
    Scanner bc =new Scanner(System.in);
    System.out.print("Enter price of Pencil:");
    float a= bc.nextFloat();
    System.out.print("Enter price of Eraser:");
    float b= bc.nextFloat();
    System.out.print("Enter price of Pen:");
    float p=bc.nextFloat();
    float gst=(a+b+p)*18/100;
    float total=(a+b+p)+gst;
    System.out.println("\n\n****RECIEPT:------*****\n\n");
    System.out.println("Pencil's price:"+a);
    System.out.println("Eraser's price:"+b);
    System.out.println("Pen's price:"+p);
    System.out.println("GST:"+gst);
    System.out.println("Total Amount:"+total);
    bc.close();
}
}