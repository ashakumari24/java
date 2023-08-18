// WAP to find largest string(lexicographical order)
public class ques2 {
public static void main (String[] args) {
    String str[]={"apple","mango","banana"};
    String largst=str[0];
    for (int i = 1; i < str.length; i++) {
        if (largst.compareTo(str[i])<0) {
            largst=str[i];
        }

    }
    System.out.println(largst);
}
}
