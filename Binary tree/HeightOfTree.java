import java.util.ArrayList;

public class HeightOfTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // public static int height(Node root)
    // {
    // if (root==null) {
    // return 0;
    // }

    // int lh=height(root.left);
    // int rh=height(root.right);
    // return Math.max(lh,rh)+1;
    // }
    // public static int count(Node root)
    // {
    // if (root==null) {
    // return 0;
    // }

    // int lh=count(root.left);
    // int rh=count(root.right);
    // return lh+rh+1;
    // }
    // public static int sum(Node root)
    // {
    // if (root==null) {
    // return 0;
    // }

    // int lh=sum(root.left);
    // int rh=sum(root.right);
    // return lh+rh+root.data;
    // }
    // public static int diameter(Node root)
    // {
    // if (root==null) {
    // return 0;
    // }
    // int leftDiam=diameter(root.left);
    // int leftHt=height(root.left);
    // int rightDia=diameter(root.right);
    // int rightHt=height(root.right);
    // int selfDia=leftHt+rightHt+1;
    // return Math.max(selfDia, Math.max(leftDiam, rightDia));
    // }

    static class Info {
        int diam;
        int ht;

        public Info(int d, int ht) {
            this.diam = d;
            this.ht = ht;
        }
    }

    public static Info diameter(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        return new Info(diam, ht);
    }

    public static boolean isIdentical(Node node, Node subRoot) {
        if (node == null && subRoot == null) {
            return true;
        } else if (node == null || subRoot == null || node.data != subRoot.data) {
            return false;
        }

        if (!isIdentical(node.left, subRoot.left)) {
            return false;
        }
        if (!isIdentical(node.right, subRoot.right)) {
            return false;
        }

        return true;
    }

    public static boolean isSubtree(Node root, Node SubRoot) {
        if (root == null) {
            return false;
        }

        if (root.data == SubRoot.data) {
            if (isIdentical(root, SubRoot)) {
                return true;
            }
        }

        return isSubtree(root.left, SubRoot) || isSubtree(root.right, SubRoot);
    }

    public static void KLevel(Node root, int level, int k) {
        if (root == null) {
            return;
        }
        if (level == k) {
            System.out.print(root.data + " ");
        }

        KLevel(root.left, level + 1, k);
        KLevel(root.right, level + 1, k);

    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if (root == null) {
            return false;
        }

        path.add(root);
        if (root.data == n) {
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if (foundLeft || foundRight) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

    public static Node lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }

        Node lca = path1.get(i - 1);
        return lca;
    }

    public static Node lca2(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }
        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        if (rightLca == null) {
            return leftLca;
        }

        if (leftLca == null) {
            return rightLca;
        }

        return root;
    }

    public static int lcaDist(Node root, int n) {
        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }

        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        } else if (leftDist == -1) {
            return rightDist + 1;
        } else {
            return leftDist + 1;
        }
    }

    public static int minDist(Node root, int n1, int n2) {
        Node lca = lca2(root, n1, n2);
        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);

        return dist1 + dist2;
    }

    public static int KAncestor(Node root, int n, int k) {
        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }

        int leftDist = KAncestor(root.left, n, k);
        int rightDist = KAncestor(root.right, n, k);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }

        int max = Math.max(leftDist, rightDist);
        if (max + 1 == k) {
            System.out.println(root.data);
        }

        return max + 1;
    }

    public static int transform(Node root) {
        if (root == null) {
            return 0;
        }

        int leftChild = transform(root.left);
        int rightChild = transform(root.right);

        int data = root.data;

        int newLeft = root.left == null ? 0 : root.left.data;
        int newright = root.right == null ? 0 : root.right.data;

        root.data = newLeft + leftChild + rightChild + newright;
        return data;
    }

    public static void preorder(Node root){
        if (root==null) {
            System.out.print(-1+" ");
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        /*
         * 1
         * / \
         * 2 3
         * / \ / \
         * 4 5 6 7
         * 
         * 
         * 
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // System.out.println(count(root));
        // System.out.println(sum(root));
        // System.out.println(height(root));

        // Info i1=diameter(root);
        // System.out.println(i1.diam);

        /*
         * 
         * 2
         * / \
         * 4 5
         */
        // Node subRoot=new Node(2);
        // subRoot.left=new Node(4);
        // subRoot.right=new Node(5);

        // System.out.println( isSubtree(root, subRoot));

        // KLevel(root, 1, 3);
        // int n1 = 4;
        // int n2 = 2;
        // System.out.println(KAncestor(root, n1, n2));

        // root.data=transform(root);
        // preorder(root);
    }

}
