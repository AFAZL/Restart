
// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;

class BST {
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
        public static Node insert(Node root, int val) {
            if (root == null) {
                root = new Node(val);
                return root;
            }
            if (root.data > val) {
                root.left = insert(root.left, val);
            } else {
                root.right = insert(root.right, val);
            }
            return root;
        }

        public static void inOrder(Node root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        public static boolean search(Node root, int k) {
            if (root == null) {
                return false;
            }
            if (root.data == k) {
                return true;
            }
            if (root.data > k) {
                return search(root.left, k);
            } else {
                return search(root.right, k);
            }
        }

        public static Node del(Node root, int val) {
            if (root == null) {
                return null;
            }
            if (root.data > val) {
                root.left = del(root.left, val);
            } else if (root.data < val) {
                root.right = del(root.right, val);
            } else {
                // case 1:
                if (root.left == null && root.right == null) {
                    return null;
                }
                // Case 2:
                else if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                }
                // Case 3:
                else {
                    Node IS = IS(root.right);
                    root.data = IS.data;
                    root.right = del(root.right, IS.data);

                }
            }
            return root;
        }

        public static void Range(Node root, int x, int y) {
            if (root == null) {
                return;
            }
            if (x <= root.data && root.data <= y) {
                Range(root.left, x, y);
                System.out.print(root.data + " ");
                Range(root.right, x, y);
            } else if (root.data < x) {
                Range(root.right, x, y);
            } else {
                Range(root.left, x, y);
            }

        }

        public static Node IS(Node root) {
            while (root.left != null) {
                root = root.left;
            }
            return root;
        }

        public static void Pri(ArrayList<Integer> path) {
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i) + "->");
            }
            System.out.println("");
        }

        public static void leafPath(Node root, ArrayList<Integer> path) {
            if (root == null) {
                return;
            }
            path.add(root.data);
            if (root.left == null && root.right == null) {
                Pri(path);
            } else {
                leafPath(root.left, path);
                leafPath(root.right, path);
            }
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            int x = values[i];
            root = BT.insert(root, x);
        }
        // BST.inOrder(root);
        // boolean ans = BST.search(root,11);
        // System.out.println(" ");
        // ArrayList<Integer>path = new ArrayList<>();
        // BST.leafPath(root,path);
        // BST.Range(root,4,100);
        // BST.del(root,10);
        // BST.inOrder(root);
    }
}