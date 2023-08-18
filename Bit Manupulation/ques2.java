// Check if a number is a power of 2 or not
public class ques2 {
    public static boolean isPowerOfTwo(int n) {
        return (n & (n - 1)) == 0;
    }

    // count total no of set bit in a given number
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static int fastExpo(int a, int n) {
        int ans = 1;
        while (n > 0) {
            if ((n | 1) != 0) {
                ans = ans * a;
            }
            a = a * a;
            n = n >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        // System.out.println(isPowerOfTwo(15));
        // System.out.println(countSetBits(7));
        System.out.println(fastExpo(5, 3));

    }
}