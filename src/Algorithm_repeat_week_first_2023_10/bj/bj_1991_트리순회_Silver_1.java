package Algorithm_repeat_week_first_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_1991_트리순회_Silver_1 {
    static class Node {
        char head; Node left;Node right;

        public Node(char head, Node left, Node right) {
            this.head = head;
            this.left = left;
            this.right = right;
        }
    }
    static int N;
    static  StringBuilder sb;
    static Node rootNode = new Node('A',null,null);
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            String str = br.readLine();
            char head = str.charAt(0);
            char left = str.charAt(2);
            char right = str.charAt(4);
            insertNode(rootNode,head,left,right);

        }

        sb = new StringBuilder();
        preOrder(rootNode);
        sb.append("\n");
        centOrder(rootNode);
        sb.append("\n");
        lastOrder(rootNode);
        System.out.println(sb.toString());
    }
    static void insertNode(Node tmp,char head, char left,char right){
        if(tmp.head==head) {
            tmp.left    =(left=='.' ? null: new Node(left,null,null));
            tmp.right    =(right=='.' ? null: new Node(right,null,null));
        }else{
            if(tmp.left!=null)insertNode(tmp.left,head,left,right);
            if(tmp.right!=null)insertNode(tmp.right,head,left,right);
        }
    }
    static void lastOrder(Node node){
        if(node==null) return;
        lastOrder(node.left);
        lastOrder(node.right);
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
        preOrder(node.right);
        preOrder(node.left);
    }
}
