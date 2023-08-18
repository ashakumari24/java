public class pra9 {
    public static void BubbleSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void SelectionSort(int arr[]) {
        int MinIndex, temp;
        for (int i = 0; i < arr.length; i++) {
            MinIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[MinIndex]) {
                    MinIndex = j;
                }
            }
            temp = arr[MinIndex];
            arr[MinIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void InsertionSort(int arr[]) {
        for (int i = 1; i <= arr.length - 1; i++) {
            int cur = arr[i];
            int prev = i - 1;
            while (prev >= 0 && arr[prev] < cur) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = cur;
        }
    }

    public static void PrintArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int numbs[] = { 3, 6, 2, 1, 8, 7, 4, 5, 3, 1 };
        BubbleSort(numbs);
        // SelectionSort(numbs);
        // InsertionSort(numbs);
        PrintArray(numbs);
    }
}