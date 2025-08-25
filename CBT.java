
// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;

class CBT {
    Node root;

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

    static class BT {
        static int i = -1;

        public static Node buildTree(int[] nodes) {
            i++;
            if (nodes[i] == -1) {
                return null;
            }
            Node nn = new Node(nodes[i]);
            nn.left = buildTree(nodes);
            nn.right = buildTree(nodes);

            return nn;
        }
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node c = q.remove();
            if (c == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(c.data + " ");
                if (c.left != null) {
                    q.add(c.left);
                }
                if (c.right != null) {
                    q.add(c.right);
                }
            }
        }
    }

    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int lc = countNodes(root.left);
        int rc = countNodes(root.right);

        return lc + rc + 1;
    }

    public static int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int ls = sumOfNodes(root.left);
        int rs = sumOfNodes(root.right);

        return ls + rs + root.data;
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh) + 1;
    }

    public static int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int ld = diameter(root.left);
        int rd = diameter(root.right);
        int cd = height(root.left) + height(root.right) + 1;

        return Math.max(Math.max(ld, rd), cd);
    }

    public static boolean isIdentical(Node root, Node sub) {
        if (root == null && sub == null) {
            return true;
        }
        if (root == null || sub == null) {
            return false;
        }
        if (root.data == sub.data) {
            return isIdentical(root.left, sub.left) && isIdentical(root.right, sub.right);
        }
        return false;
    }

    public static boolean isSubTree(Node root, Node sub) {
        if (sub == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (root.data == sub.data) {
            if (isIdentical(root, sub)) {
                return true;
            }
        }
        return isSubTree(root.left, sub) || isSubTree(root.right, sub);
    }

    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node ans = BT.buildTree(nodes);
        BT.i = -1;
        int sub[] = { 9, 4, -1, -1, 5, -1, -1 }; // ✅ Subtree

        Node subRoot = BT.buildTree(sub);
        System.out.println(ans.data);
        preOrder(ans);
        System.out.println("");
        inOrder(ans);
        System.out.println("");
        postOrder(ans);
        System.out.println("");
        levelOrder(ans);
        System.out.println("Lets move to advance :-> ");
        boolean res = isIdentical(subRoot, subRoot);
        System.out.println("Sub tree matches :-> " + res);
    }
}