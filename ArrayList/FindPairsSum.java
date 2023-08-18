import java.util.ArrayList;
import java.util.Collections;

public class FindPairsSum {
    // for unsorted array (O(n^2))
    public static boolean sumPairs1(ArrayList<Integer> list,int target)
    {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(i)+list.get(j)==target) {
                    return true;
                }
            }
        }
        return false;
    }
    // for sorted array (O(n))
    public static boolean sumPairs2(ArrayList<Integer> list,int target)
    {
        int lp=0;
        int rp=list.size()-1;
        while (lp<rp) {
            if (list.get(lp)+list.get(rp)==target) {
                return true;
            }
            else if(list.get(lp)+list.get(rp)<target)
            {
                lp++;
            }
            else
            {
                rp--;
            }
        }
        return false;
    }
    // for roted array (O(n))
    public static boolean sumPairs3(ArrayList<Integer> list,int target)
    {
        int n=list.size();
        int bp=-1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)>list.get(i+1)) {
                bp=i;
                break;
            }
        }
        int lp=bp+1;
        int rp=bp;
        while (lp!=rp) {
            if (list.get(lp)+list.get(rp)==target) {
                    return true;
            }
            if (list.get(lp)+list.get(rp)<target) {
                lp=(lp+1)%n;
            }
            else{
                rp=(n+rp-1)%n;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(3);
        list.add(7);
        // System.out.println(sumPairs1(list, 9));
        Collections.sort(list);
        System.out.println(sumPairs2(list, 9));

    }
}
