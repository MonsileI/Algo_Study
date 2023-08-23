package Algorithm_sixth_week_2023_08.bj;

import java.io.*;
import java.util.*;
public class bj_1991_트리의순회_Silver_1_myself {

    static class Node{
        char head; Node left; Node right;

        public Node(char head,Node left,Node right){
            this.head = head;
            this.left = left;
            this.right = right;
        }
    }
    static Node head = new Node('A',null,null);
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            insertOrder(head,root,left,right);
        }
        preOrder(head);
        sb.append("\n");
        inOrder(head);
        sb.append("\n");
        postOrder(head);
        System.out.println(sb.toString());
    }

    static void insertOrder(Node tmp, char root, char left, char right){
        if(tmp.head==root){
            tmp.left = (left=='.' ? null : new Node(left,null,null));
            tmp.right = (right=='.' ? null : new Node(right,null,null));
        }else{
            if(tmp.left!=null) insertOrder(tmp.left,root,left,right);
            if(tmp.right!=null) insertOrder(tmp.right,root,left,right);
        }
    }
    static void preOrder(Node n){
        if(n==null) return;
        sb.append(n.head);
        preOrder(n.left);
        preOrder(n.right);
    }
    static void inOrder(Node n){
        if(n==null) return;
        inOrder(n.left);
        sb.append(n.head);
        inOrder(n.right);
    }
    static void postOrder(Node n){
        if(n==null) return;
        postOrder(n.left);
        postOrder(n.right);
        sb.append(n.head);
    }
}