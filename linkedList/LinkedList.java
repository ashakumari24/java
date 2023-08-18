public class 	LinkedList {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    static int size=0;
    public void print()
    {
        if (size==0) {
            System.out.println("List is empty");
        }
        Node temp=head;
        while (temp!=null) {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    // Inserting
    public void addFirst(int data)
    {
        Node newNode=new Node(data);
        size++;
        if (head==null) {
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }
    public void addLast(int data)
    {
        size++;
        Node newNode=new Node(data);
        tail.next=newNode;
        tail=newNode;
    }
    public void addPosition(int data,int index)
    {
        size++;
        Node newNode=new Node(data);
        Node tempNode=head;
        int i=1;
        while (i<index-1) {
            tempNode=tempNode.next;
            i++;
        }
        newNode.next=tempNode.next;
        tempNode.next=newNode;
    }
    // Deleting
    public int removeFirst()
    {
        if (size==0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if(size==1)
        {
            int val =head.data;
            head=tail=null;
            size=0;
            return val;
        }
        int val=head.data;
        head=head.next;
        size--;
        return val;

    }
    public int removeLast()
    {
        if (size==0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if (size==1) {
            int val=tail.data;
            head=tail=null;
            size=0;
            return val;
        }
        Node temp=head;
        while (temp.next.next!=null) {
            temp=temp.next;
        }
        int val=temp.next.data;
        temp.next=null;
        size--;
        tail=temp;
        return val;
    }
    public int removeAtPosition(int index)
    {
        int i=1;
        Node temp=head;
        while (i<index-1) {
            temp=temp.next;
            i++;
        }
        int val=temp.next.data;
        temp.next=temp.next.next;
        size--;
        return val;
    }
    // Searching
    public int itrSearch(int key)
    {
        Node temp=head;
        int i=0;
        while (temp!=null) {
            i++;
            if (temp.data==key) {
                return i;
            }
            temp=temp.next;
        }
        return -1;
    }
    public int helper(Node head, int key)
    {
        if (head==null) {
            return -1;
        }
        if (head.data==key) {
            return 1;
        }
        int idx=helper(head.next, key);
        if (idx==-1) {
            return -1;
        }
        return idx+1;
    }
    public int recSearch(int key)
    {
        return helper(head, key);
    }
    // reverse
    public void reverse()
    {
        Node prev=null;
        Node curr=tail=head;
        Node next;
        while (curr!=null) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }
    // To Check Polindrome LL
    public  Node findMid(Node head)
    {
        Node slow=head;
        Node fast=head;
        while (fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public boolean checkPalindrome()
    {
        if (head==null || head.next==null) {
            return true;
        }
        Node midNode=findMid(head);
        Node prev=null;
        Node curr=midNode;
        Node next;
        while (curr!=null) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node right=prev;
        Node left=head;
        while (right!=null) {
            if (left.data!=right.data) {
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    }
    // checking cycle
    public boolean isCycle()
    {
        Node slow=head;
        Node fast=head;
        while (fast!=null&&fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast) {
                return true;
            }
        }
        return false;
    }
    // remove cycle
    public void removeCycle(){
        Node slow=head;
        Node fast=head;
        boolean cycle=false;
        while (fast!=null&&fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
            if (fast==slow) {
                cycle=true;
                break;
            }
        }
        if (cycle==false) {
            return;
        }
        slow=head;
        Node prev=null;
        while (slow!=fast) {
            prev=fast;
            slow=slow.next;
            fast=fast.next;
        }
        prev.next=null;
    }
    // merge sort
    private Node merge(Node head1, Node head2)
    {
        Node mergedLL=new Node(-1);
        Node temp=mergedLL;
        while (head1!=null && head2!=null) {
            if (head1.data<=head2.data) {
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }
            else{
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        }
        while (head1!=null) {
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }
        while(head2!=null)
        {
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }
        return mergedLL.next;
    }
    public  Node mergeSort(Node head){
        if (head==null || head.next==null) {
            return head;

        }
        Node mid=findMid(head);
        Node rightHead=mid.next;
        mid.next=null;
        Node newLeft=mergeSort(head);
        Node newRight=mergeSort(rightHead);
        return merge(newLeft,newRight);
    }
    // zig-zag LL
    public void zigZag()
    {
        Node slow=head;
        Node fast=head.next;
        while (fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;

        }
        Node mid=slow;
        Node curr=mid.next;
        mid.next=null;
        Node prev=null;
        Node next;
        while (curr!=null) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node left=head;
        Node right=prev;
        Node nextL,nextR;
        while (left!=null && right!=null) {
            nextL=left.next;
            left.next=right;
            nextR=right.next;
            right.next=nextL;

            left=nextL;
            right=nextR;
        }
    }
public static void main (String[] args) {
    LinkedList ll1=new LinkedList();
//    Node tempNode=new Node(8);
//    Node tempNode2=new Node(36);
//    Node tempNode3=new Node(387);
//    ll1.addFirst(85);
//    ll1.addFirst(8);
//    ll1.addFirst(100);
//    ll1.addFirst(13);
//    ll1.addFirst(139);
//    ll1.tail.next=tempNode;
//    tempNode.next=tempNode2;
//    tempNode2.next=tempNode3;
//    tempNode3.next=tempNode;
//    System.out.println(ll1.isCycle());
//    ll1.removeCycle();
    
//       ll1.print();
    //   ll1.mergeSort(head);
    //   ll1.print();
    // ll1.addFirst(1);
    // ll1.addLast(2);
    // ll1.addLast(6);
    // ll1.addLast(3);
    // ll1.addLast(2);
    // ll1.print();
    // System.out.println();
    // ll1.zigZag();
    // ll1.print();
    ll1.addFirst(1);
    ll1.addFirst(2);
    ll1.addFirst(3);
    ll1.addFirst(4);
    ll1.addFirst(5);
    ll1.print();
    System.out.println();
    ll1.head=ll1.mergeSort(ll1.head);
    ll1.print();
}
}