/* You are given an array prices where prices[i] is the price of a given stock on 
the i
th day.
Return the maximum profit you can achieve from this transaction. If you cannot 
achieve any profit, return 0 */
public class pra8 {
    public static int StockBuySelling(int arr[])
    {
        int k=0,m=0,buy;
        buy=Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<buy)
            {
                buy=arr[i];
                k=i;
            }
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i]>buy) {
                m=i;
            }
        }
        if (m==0) {
            return 0;
        }
        return m;

    }
public static void main (String[] args) {
    int num[]={7, 6, 4, 3, 1};
    System.out.println(StockBuySelling(num));
}
}