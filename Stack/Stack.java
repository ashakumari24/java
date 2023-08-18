import java.util.ArrayList;

public class 	Stack {
    static class StackB{
        static ArrayList<Integer> list=new ArrayList<>();
        public static boolean isEmpty()
        {
            if (list.size()==0) {
                return true;
            }
            return false;
        }
        // push
        public static void push(int data)
        {
            list.add(data);
        }
        // pop
        public static int pop()
        {
            
            int top=list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }
        // peek
        public static int peek()
        {
            return list.get(list.size()-1);
        }
    }
public static void main (String[] args) {
     StackB s=new StackB();
     s.push(1);    
     s.push(2);    
     s.push(3);    
     s.push(4);    
     while (!s.isEmpty()) {
        System.out.print(s.peek()+" ");
        s.pop();
     }
}
}