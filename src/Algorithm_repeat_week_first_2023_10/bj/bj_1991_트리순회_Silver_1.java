package Algorithm_repeat_week_first_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_1991_트리순회_Silver_1 {

    static class Node {
        char head;
        Node right;
        Node left;

        public Node(char head, Node right, Node left) {
            this.head = head;
            this.right = right;
            this.left = left;
        }
    }

    static Node root = new Node('A', null, null);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            char head = str.charAt(0);
            char left = str.charAt(2);
            char right = str.charAt(4);
            insertNode(root, head, left, right);
        }
        preOrder(root);
        sb.append("\n");
        centOrder(root);
        sb.append("\n");
        lastOrder(root);
        System.out.println(sb.toString());
    }

    static void preOrder(Node node) {
        if(node==null) return;
        sb.append(node.head);
        preOrder(node.left);
        preOrder(node.right);
    }

    static void centOrder(Node node) {
        if(node==null) return;
        centOrder(node.left);
        sb.append(node.head);
        centOrder(node.right);
    }

    static void lastOrder(Node node) {
        if(node==null) return;
        lastOrder(node.left);
        lastOrder(node.right);
        sb.append(node.head);
    }
    static void insertNode(Node node,char head,char left,char right){
        if(node.head==head){
            node.left = (left=='.' ? null : new Node(left,null,null));
            node.right = (right=='.' ? null : new Node(right,null,null));
        }else{
            if(node.left!=null) insertNode(node.left,head,left,right);
            if(node.right!=null) insertNode(node.right,head,left,right);
        }
    }

}
