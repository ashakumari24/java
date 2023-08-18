public class 	string_compression {
    public static String StringCompression(String str)
    {
        StringBuilder newStr=new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            Integer count=1;
            while (i<str.length()-1 && str.charAt(i)==str.charAt(i+1)) {
                count++;
                i++;
            }
            newStr.append(str.charAt(i));
            if (count>1) {
                newStr.append(count.toString());
            }
        }
        return newStr.toString();
    }
public static void main (String[] args) {
    String str="aaabbcccdddd";
    System.out.println(StringCompression(str));
}
}