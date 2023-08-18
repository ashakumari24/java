import java.util.ArrayList;

public class BST {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node buildTree(Node root, int val) {

        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            root.left = buildTree(root.left, val);
        } else {
            root.right = buildTree(root.right, val);
        }

        return root;
    }

    public static boolean search(Node root, int val) {

        if (root == null) {
            return false;
        }
        if (root.data == val) {
            return true;
        }

        if (root.data > val) {
            return search(root.left, val);
        } else {
            return search(root.right, val);
        }

    }
   
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        inorder(root.left);
        inorder(root.right);
    }

    public static Node delete(Node root, int val) {
        if (root.data < val) {
            root.right = delete(root.right, val);
        } else if (root.data > val) {
            root.left = delete(root.left, val);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }

        return root;
    }

    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;

    }

    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if (root.data < k1) {
            printInRange(root.left, k1, k2);
        } else {
            printInRange(root.right, k1, k2);
        }
    }

    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + "->");
        }

        System.out.println("Null");
    }

    public static void printRoot2leaf(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            printPath(path);
        }

        printRoot2leaf(root.left, path);
        printRoot2leaf(root.right, path);
        path.remove(path.size() - 1);
    }

    public static boolean isValidBST(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.data <= min.data) {
            return false;
        } else if (max != null && root.data >= max.data) {
            return false;
        }
        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }

    public static Node createMirror(Node root) {
        if (root == null) {
            return null;
        }

        Node leftMirror = createMirror(root.left);
        Node rightMirror = createMirror(root.right);

        root.left = rightMirror;
        root.right = leftMirror;
        return root;
    }

    public static Node createBalancedBST(int arr[], int st, int en) {
        if (st > en) {
            return null;
        }

        int mid = (st + en) / 2;
        Node root = new Node(arr[mid]);
        root.left = createBalancedBST(arr, st, mid - 1);
        root.right = createBalancedBST(arr, mid + 1, en);
        return root;
    }

    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isbst,int size,int min,int max){
            this.isBST=isbst;
            this.size=size;
            this.min=min;
            this.max=max;
        }
    }

    public static int maxBST=0;

    public static Info largestBST(Node root){
        if (root==null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info leftInfo=largestBST(root.left);
        Info rightInfo=largestBST(root.right);
        int size=leftInfo.size+rightInfo.size+1;
        int min=Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max=Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if(root.data<=leftInfo.max || root.data>=rightInfo.min){
            return new Info(false,size,min,max);
        }

        if(leftInfo.isBST && rightInfo.isBST){
            maxBST=Math.max(maxBST, size);
            return new Info(true,size,min,max);
        }

        return new Info(false,size,min,max);
    }

    public static void getInorder(Node root,ArrayList<Integer> arr){
        if (root==null) {
            return;
        }

        getInorder(root.left, arr);
        arr.add(root.data);
        getInorder(root.right, arr);
    }

    public static Node createBST(ArrayList<Integer> arr,int st,int end){
        if (st>end) {
            return null;
        }

        int mid=(st+end)/2;

        Node root=new Node(arr.get(mid));
        root.left=createBST(arr, st, mid-1);
        root.right=createBST(arr, mid+1, end);
        return root;
    }

    public static Node mergeBSts(Node root1,Node root2){
        ArrayList<Integer> arr1=new ArrayList<>();
        getInorder(root1, arr1);

        ArrayList<Integer> arr2=new ArrayList<>();
        getInorder(root2, arr2);


        int i=0,j=0;
        ArrayList<Integer> finalArr=new ArrayList<>();
        while (i<arr1.size() && j<arr2.size()) {
            if (arr1.get(i)<=arr2.get(j)) {
               
                finalArr.add(arr1.get(i));
                i++;
            }else{

                finalArr.add(arr2.get(j));
                j++;
            }
        }

        while (i<arr1.size()) {
            finalArr.add(arr1.get(i));
            i++;
        }

        while (j<arr2.size()) {
            finalArr.add(arr2.get(j));
            j++;
        }

        return createBST(finalArr, 0, finalArr.size()-1);
    }

    public static void main(String[] args) {
        // Node root = null;
        // int arr[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        // int arr[] = {1,1,1,1};
        // int arr[] = { 3, 5, 6, 8, 10, 11, 12 };
        // for (int i = 0; i < arr.length; i++) {
        // root = buildTree(root, arr[i]);
        // }

        // inorder(root);
        // System.out.println();

        // delete(root, 1);
        // System.out.println();
        // inorder(root);
        // if(search(root, 6))
        // {
        // System.out.println("found");
        // }
        // else{
        // System.out.println("Not found");

        // }

        // printInRange(root, 5, 12);
        // printRoot2leaf(root, new ArrayList<>());

        // if (isValidBST(root, null, null)) {
        // System.out.println("valid");

        // }
        // else{
        // System.out.println("Not Valid");
        // }
        // System.out.println();
        // root=createMirror(root);
        // preorder(root);

        // root = createBalancedBST(arr, 0, arr.length - 1);
        // preorder(root);



        // Node root=new Node(50);
        // root.left=new Node(30);
        // root.left.left=new Node(5);
        // root.left.right=new Node(20);

        // root.right=new Node(60);
        // root.right.left=new Node(45);
        // root.right.right=new Node(70);
        // root.right.right.left=new Node(65);
        // root.right.right.right=new Node(80);

        // Info i1=largestBST(root);
        // System.out.println("Laegest BSTs Nodes = "+maxBST);

// Merging 2 BSTs:------

        /*
                   2
                  / \
                 1   4
                 
                 BST1
         */


         Node root1=new Node(2);
         root1.left=new Node(1);
         root1.right=new Node(4);

         /*
                   9
                  / \
                 3   12
                 
                 BST2
         */


         Node root2=new Node(9);
         root2.left=new Node(3);
         root2.right=new Node(12);

         Node root3=mergeBSts(root1, root2);

         inorder(root3);

    }
}