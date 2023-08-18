public class 	ques {
    public static void OddEven(int n)
    {
        int bitmask=1;
        if ((n & bitmask)==0) {
            System.out.println("Even Number");
        }
        else{
            System.out.println("Odd Number");

        }
    }
    public static int getIthBit(int n,int i)
    {
        int bitmask=i<<i;
        if ((n&bitmask)==0) {
            return 0;
        }
        else
        return 1;
    }
    public static int setIthBit(int n, int i)
    {
        int bitmask=1<<i;
        return n|bitmask;
    }
    public static int clearIthBit(int n, int i)
    {
        int bitmask=~(1<<i);
        return n & bitmask;
        // int bitmask=(~0)<<i;
        // return n & bitmask;

    }
    public static int UpdateIthBit(int n, int i, int newBit)
    {
        if (newBit==0) {
            return clearIthBit(n, i);
        } else {
            return setIthBit(n, i);
        }
        // n=clearIthBit(n, i);
        // int bitmask=newBit<<i;
        // return n|bitmask;
    }
    public static int clearIBits(int n, int i, int j)
    {
        int a=((~0)<<(j+1));
        int b=(1<<i)-1;
        int bitmask=a|b;
        return n&bitmask;
    }

public static void main (String[] args) {
    // OddEven(9);
    // OddEven(10);
    // System.out.println(getIthBit(4, 2));
    // System.out.println(clearIthBit(4, 1));
    // System.out.println(UpdateIthBit(4, 1,2));
    System.out.println(clearIBits(13, 1, 2));


}
}