public class DoubleLinkedList {
    public class Node{
        int data;
        Node next;
        Node prev;
       public Node(int data)
        {
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    // Add
    public void addFirst(int data)
    {
        Node newNode=new Node(data);
        size++;
        if (head==null) {
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
    }
    public void print(){
        Node temp=head;
        while (temp!=null) {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();

    }
    public static void main(String[] args) {
        DoubleLinkedList ll=new DoubleLinkedList();
        ll.addFirst(54);
        ll.addFirst(53);
        ll.addFirst(52);
        ll.addFirst(51);
        ll.addFirst(50);
        ll.print();
    }
}
