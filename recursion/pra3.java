public class 	pra3 {
    public static int powerCal(int n, int p)
    {
        if (p==1) {
            return n*p;
        }
        return n*powerCal(n, p-1);
    }
    public static int optimizedPower(int a, int n)
    {
        if (n==0) {
            return 1;
        }
        int halfpower=optimizedPower(a,n/2);
        int halfPowersq=halfpower*halfpower;
        if (n%2!=0) {
            halfPowersq=a*halfPowersq;
        }
        return halfPowersq;
    }
public static void main (String[] args) {
    int n=2,p=5;
    System.out.println(optimizedPower(p, n));
}
}