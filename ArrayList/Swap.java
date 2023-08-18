import java.util.ArrayList;

public class Swap {
    public static void swap(ArrayList<Integer> list, int inx1, int inx2) {
        int temp = list.get(inx1);
        list.set(inx1, list.get(inx2));
        list.set(inx2, temp);
    }
    public static void main(String args[])
    {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(9);
        list.add(4);
        list.add(3);
        list.add(89);
        list.add(8);
        int idx1=1,idx2=3;
        System.out.println(list);
        swap(list, idx1, idx2);
        System.out.println(list);
    }
}

