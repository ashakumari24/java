public class SubArray {
    public static void subarray(int arr[]) {
        int m = Integer.MIN_VALUE;
        int sum = 0;
        int tp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                sum = 0;
                for (int j2 = i; j2 < j; j2++) {

                    System.out.print(arr[j2]);
                    tp++;
                    sum += arr[j2];
                }
                if (m < sum) {
                    m = sum;
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("max sum " + m);
        System.out.println("total tp: " + tp);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, -4, 5 };
        subarray(arr);
    }
}