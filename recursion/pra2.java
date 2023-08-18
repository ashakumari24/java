public class 	pra2 {
    // To check given array is sorted or not
    public static boolean isSorted(int arr[],int i)
    {
        if (i==arr.length-1) {
            return true;
        }
        if (arr[i]>arr[i+1]) {
            return false;
        }
        return isSorted(arr,i+1);
    }
    // To find 1st Occurence of given number in an array
    public static int firstOccurence(int arr[],int key, int i)
    {
        if (i==arr.length  ) {
           return -1;
        }
        if (arr[i]==key) {
            return i;
        }
        return firstOccurence(arr, key, i+1);
    }
    // To find last Occurence of given number in an array
    public static int lastOccurence(int arr[],int key, int i)
    {
        if (i==arr.length  ) {
           return -1;
        }
        int isFound=lastOccurence(arr, key, i+1);
        if (isFound==-1 && arr[i]==key) {
            return i;
        }
        return isFound;
    }
public static void main (String[] args) {
    int arr[]={1,2,3,4,10,6};
    // System.out.println(isSorted(arr, 2));
    System.out.println(lastOccurence(arr, 4, 0));
}
}