import java.util.Stack;

public class InBuiltStack {
    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);

    }

    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while (idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder result = new StringBuilder("");
        while (!s.isEmpty()) {
            char curr = s.pop();
            result.append(curr);
        }
        return result.toString();
    }

    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    public static void print(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");

        }
        ;
    }

    //
    public static void stockSpan(int stocks[], int span[]) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);
        for (int i = 1; i < stocks.length; i++) {
            int currPrice = stocks[i];
            while (!s.isEmpty() && currPrice > stocks[s.peek()]) {
                s.pop();

            }
            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                int preHigh = s.peek();
                span[i] = i - preHigh;
            }
            s.push(i);
        }
    }

   
    public static void main(String[] args) {
        // Stack<Integer> s=new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // s.push(4);
        // pushAtBottom(s, 0);
        // // print(s);//4 3 2 1 0
        // reverseStack(s);
        // print(s);
        // pushAtBottom(s, 52);
        // while (!s.isEmpty()) {
        // System.out.print(s.peek()+" ");
        // s.pop();
        // }
        // String str="abc";
        // String reult=reverseString(str);
        // System.out.println(reult);

        // int stocks[] = { 100, 80, 60, 70, 60, 85, 100 };
        // int span[] = new int[stocks.length];
        // stockSpan(stocks, span);
        // for (int i = 0; i < span.length; i++) {
        //     System.out.println(span[i] + " ");
        // }


          // The next greater elsement of some element x in an array is the first greater
    // element that is the right is to the right of x in the same array
    // arr=[6,8,0,1,3]
    // next greater=[8,-1,1,3,-1]

           int arr[]={1, 2, 3, 4, 5, 6};
           Stack<Integer> s=new Stack<>();
           int nextGreater[]=new int[arr.length];
            
           for (int i = arr.length-1; i >= 0; i--) {
               while (!s.isEmpty() && arr[s.peek()]<=arr[i]) {
                  s.pop();
               }
               if (s.isEmpty()) {
                  nextGreater[i]=-1;
               }
               else{
                nextGreater[i]=arr[s.peek()];
               }
               s.push(i);
           }

           for (int i = 0; i < nextGreater.length; i++) {
             System.out.print(nextGreater[i]+" ");
           }
    }
}
