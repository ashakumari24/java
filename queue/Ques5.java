import java.util.LinkedList;
import java.util.Queue;
public class Ques5 {
    public static void queueInterLeave(Queue<Integer> q){
        Queue<Integer> q1=new LinkedList<>();
        int size=q.size();
        for (int i = 0; i < size/2; i++) {
            q1.add(q.remove());
        }
        while (!q1.isEmpty()) {
            q.add(q1.remove());
            q.add(q.remove());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q1=new LinkedList<>();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.add(4);
        q1.add(5);
        q1.add(6);
        q1.add(7);
        q1.add(8);
        q1.add(9);
        q1.add(10);
        queueInterLeave(q1);
        while (!q1.isEmpty()) {
            System.out.print(q1.remove()+" ");
        }
    }
    
}
