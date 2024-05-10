package src;

import java.util.Scanner;
import java.util.Stack;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    public static void preOrder(Node root) {
        // root -> left subtree -> right subtree
        // use a stack ds to dictate order of traversal
        // push right child first and then left child onto stack
        // keep looping until stack is empty

        StringBuilder res = new StringBuilder();
        Stack<Node> nodes = new Stack<>();
        nodes.push(root);

        while (!nodes.isEmpty()) {
            Node currentNode = nodes.pop();
            res.append(currentNode.data).append(" ");

            if (currentNode.right != null) nodes.push(currentNode.right);
            if (currentNode.left != null) nodes.push(currentNode.left);
        }
        System.out.println(res.toString().trim());
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = input.nextInt();
            root = insert(root, data);
        }
        input.close();
        preOrder(root);
    }
}