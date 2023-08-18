public class pra10 {
   
    public static int FrequencyCount(int arr[][],int key)
    {
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (key==arr[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
    public static int Sum(int arr[][],int r)
    {
        int sum=0;
        for (int i = 0; i < arr[0].length; i++) {
            sum+=arr[r][i];
        }
        return sum;
    }
    public static void PrintArray(int arr[][])
    {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
    }
public static void main (String[] args) {
    int col=3,row=3;
    int numbs[][]=  { {1,4,9},{11,4,3},{2,2,3} };
    PrintArray(numbs);
    // System.out.println(FrequencyCount(numbs, 7));
    // System.out.println(Sum(numbs, 1));
    int [][] arr=new int[col][row];
    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
            arr[j][i]=numbs[i][j];
        }
    }
    PrintArray(arr);


}
}