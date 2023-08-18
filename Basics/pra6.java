// Array
public class pra6 {
    public static void PrintArray(int array[])
    {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }
    public static int linearSearch(int numbers[], int key) {
        for (int i = 0; i < numbers.length; i++) {
            if (key == numbers[i]) {
                return i;
            }
        }
        return 0;
    }

    public static int BinarySearch(int arr[], int key) {
        int start = arr[0];
        int end = arr.length;
        for (int i = 0; i < arr.length; i++) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                start = mid;
            } else {
                end = mid;
            }

        }
        return 0;

    }
    public static void ReverseArray(int arr[])
    {
        int temp;
        for (int i = 0; i < arr.length/2; i++) {
            temp=arr[i];
            arr[i]=arr[arr.length-1-i];
            arr[arr.length-1-i]=temp;

        }
        
    }
    public static void PrintSubArray(int array[])
    {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                for (int k = j; k < array.length; k++) {
                    System.out.print(array[k]);
                }
                System.out.println();
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        int numbers[] = { 1, 2, 3, 5, 6 };
        // int res=linearSearch(numbers, 2);
        // System.out.println(res);
        // int res = BinarySearch(numbers, 6);
        // System.out.println(res);
        // ReverseArray(numbers);
        //PrintArray(numbers);
        PrintSubArray(numbers);
        


    }
}