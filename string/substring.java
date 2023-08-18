public class substring{
    public static String SubString(String str,int si,int ei)
    {
        String substr="";
        for (int i = si; i < ei; i++) {
            substr+=str.charAt(i);
        }
        return substr;
    }
public static void main (String[] args) {
    String str="HelloWorld";
    System.out.println(str.substring(0,5));//inbuilt func
    // System.out.println(SubString(str, 0, 5));
}
}