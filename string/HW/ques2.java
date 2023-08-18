import java.util.Arrays;
public class 	ques2 {
public static void main (String[] args) {
    String str1="earth";
    String str2="heart";
    str1=str1.toLowerCase();
    str2=str2.toLowerCase();
    if (str1.length()==str2.length()) {
        char[] str1char=str1.toCharArray();
        char[] str2char=str2.toCharArray();
       Arrays.sort(str1char);
       Arrays.sort(str2char);
       boolean res=Arrays.equals(str1char, str2char);
       if (res) {
        System.out.println(str1 + " & " + str2 +" are anagram of eachother" );
       }
       else
       {
        System.out.println(str1 + " & " + str2 +" are not anagram of eachother" );

       }
    }
    else
    {
        System.out.println(str1 + " & " + str2 +" are not anagram of eachother" );

    }
}
}
