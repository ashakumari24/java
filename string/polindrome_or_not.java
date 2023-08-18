public class polindrome_or_not {
    public static boolean Polindrome(String str)
    {
        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i)!=str.charAt(str.length()-1-i)) {
                return false;
            }
        }
        return true;
    }
    public static void main (String[] args) {
        String str="madam";
        System.out.println(Polindrome(str));
    }
}
