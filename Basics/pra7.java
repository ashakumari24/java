/*: Given an integer array nums, return true if any value appears at least twice in the 
array, and return false if every element is distinct */
public class pra7 {
    public static boolean DistintOrNot(int arr[]) {
        // for (int i = 0; i < arr.length; i++) {
        // for (int j = i+1; j < arr.length; j++) {
        // if (arr[i]==arr[j]) {
        // return true;
        // }
        // }
        // }
        for (int i = 0; i < arr.length / 2; i++) {

            if (arr[i] == arr[arr.length - 1 - i]) {
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int num[] = { 1, 2, 3, 9 };
        System.out.println(DistintOrNot(num));
    }
}