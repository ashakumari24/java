public class 	pra4 {
    public static int TillingPrblm(int n)
    {
        if (n==0||n==1) {
            return 1;
        }
        return TillingPrblm(n-1)+TillingPrblm(n-2);
    }
    public static void printBinStrings(int n, int lastplace, String str)
    {
        if (n==0) {
            System.out.println(str);
            return;
        }
        printBinStrings(n-1, 0, str+"0");
        if (lastplace==0) {
            printBinStrings(n-1, 1, str+"1");
        }
    }
public static void main (String[] args) {
    // System.out.println(TillingPrblm(3));
    printBinStrings(3, 0, "");
}
}