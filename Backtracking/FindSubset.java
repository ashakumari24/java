public class FindSubset {
    public static void FindSubsets(String str, int i, String ans) {
        if (i == str.length()) {
            
                System.out.println(ans);
            
            return;
        }
        FindSubsets(str, i + 1, ans + str.charAt(i));
        FindSubsets(str, i + 1, ans);
        
    }
    /*Time complexicity=O(2^n*n)
     * space complexicity=O(n)
     */

    public static void main(String[] args) {
        String str = "abc";
        FindSubsets(str, 0, "");
    }
}
