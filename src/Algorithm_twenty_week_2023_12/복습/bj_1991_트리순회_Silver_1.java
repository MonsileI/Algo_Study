package Algorithm_twenty_week_2023_12.복습;
import java.util.*;
import java.io.*;
public class bj_1991_트리순회_Silver_1 {

   static class Node{
       char head ; Node left ; Node right;

       public Node(char head, Node left, Node right) {
           this.head = head;
           this.left = left;
           this.right = right;
       }
   }

   static Node root = new Node('A',null,null);
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            char h = str.charAt(0);
            char l = str.charAt(2);
            char r = str.charAt(4);
            insertNode(root, h, l, r);
        }
        preOrder(root);
        sb.append("\n");
        centOrder(root);
        sb.append("\n");
        postOrder(root);
        System.out.println(sb.toString());
    }
    static void postOrder(Node node){
        if(node==null) return;
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.head);
    }
    static void centOrder(Node node){
        if(node==null) return;
        centOrder(node.left);
        sb.append(node.head);
        centOrder(node.right);
    }

    static void preOrder(Node node){
        if(node==null) return;
        sb.append(node.head);
        preOrder(node.left);
        preOrder(node.right);
    }

    static void insertNode(Node node,char head, char left, char right){
        if(node.head!=head){
            if(node.left!=null) insertNode(node.left,head,left,right);
            if(node.right!=null) insertNode(node.right,head,left,right);
        }else{
            node.left = (left == '.' ? null : new Node(left,null,null));
            node.right = (right == '.' ? null : new Node(right,null,null));
        }
    }
}
