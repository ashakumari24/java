
public class pra5 {
    public static void removeDuplicate(String str, int idx, StringBuilder newstr, boolean map[]) {
        if (idx == str.length()) {
            System.out.println(newstr);
            return ;
        }
        char currChar = str.charAt(idx);
        if (map[currChar - 'a'] == true) {
            removeDuplicate(str, idx + 1, newstr, map);
        } else {
            map[currChar - 'a'] = true;
            removeDuplicate(str, idx + 1, newstr.append(currChar), map);
        }
    }
   public static int friendsPairing(int n)
   {
    if (n==1||n==2) {
        return n;
    }
    return friendsPairing(n-1)+(n-1)*friendsPairing(n-2);
   }
    public static void main(String[] args) {
        // String str = "appnnacollege";
        // removeDuplicate(str, 0, new StringBuilder(""), new boolean[26]);
        System.out.println(friendsPairing(3));
    }
}