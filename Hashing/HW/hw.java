import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 	hw {
    public static int[] twosum(int arr[],int target){
        Map<Integer,Integer> visited=new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int diff=target-arr[i];
            if (visited.containsKey(diff)) {
                return new int[]{i,visited.get(diff)};
            }

        visited.put(arr[i], i);
        }

        return new int[]{0,0};
    }

    public static String frequency(String s){
        HashMap<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        PriorityQueue<Map.Entry<Character,Integer>> pq=new PriorityQueue<>((a,b)->a.getValue()==b.getValue()?a.getKey()-b.getKey():b.getValue()-a.getValue());
        for (Map.Entry<Character,Integer>e : map.entrySet()) {
            pq.add(e);}
            StringBuilder res=new StringBuilder();
            while (pq.size()!=0) {
                char ch=pq.poll().getKey();
                int val=map.get(ch);

                while (val!=0) {
                    res.append(ch);
                    val--;
                }

            }
        return res.toString();
    }
public static void main (String[] args) {

    int arr[]={2,7,11,15};
    arr=twosum(arr, 9);

    for (int i = 0; i < arr.length; i++) {
        System.out.println(arr[i]);
    }

    String s="cccaaa";
    s=frequency(s);
    System.out.println(s);
}
}