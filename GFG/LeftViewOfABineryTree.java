package GFG;

import java.util.ArrayList;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class LeftViewOfABineryTree {

   void printLeftView(Node root) {
        ArrayList<Node> list = new ArrayList<>();
        printLeftViewUtil(root, list, 0);

        for (Node cur : list) {
            System.out.print(cur.data + " ");
        }
    }

    void printLeftViewUtil(Node root, ArrayList<Node> list, int level) {
        if (root == null) {
            return;
        }

        // If this level has not been added yet, add it
        if (level >= list.size()) {
            list.add(root);
        }

        printLeftViewUtil(root.left, list, level + 1);
        printLeftViewUtil(root.right, list, level + 1);
    }

    public static void main(String[] args) {
        LeftViewOfABineryTree tree = new LeftViewOfABineryTree();
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);

        System.out.println("Left View of the Tree:");
        tree.printLeftView(root);
    }
}
