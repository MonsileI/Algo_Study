package Algorithm_sixth_week_2023_08.bj;

import java.io.*;
import java.util.*;

public class bj_1068_트리_Gold_5_myself {

    static int N, parents[];
    static int head;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        parents = new int[N];
        for (int i = 0; i < N; i++) {
            int root = Integer.parseInt(st.nextToken());
            parents[i] = root;
            if (root == -1) head = i;
        }

        deleteNode(Integer.parseInt(br.readLine()));
        visited = new boolean[N];
        countLeaf(head);
        System.out.println(answer);
    }
    static void countLeaf(int node){
        visited[node] = true;
        boolean check = true;
        if(parents[node]!=-2){
            for(int i=0;i<N;i++){
                if(!visited[i]&&parents[i]==node){
                    check= false;
                    countLeaf(i);
                }
            }
            if(check) answer++;
        }
    }
    static void deleteNode(int node){
        parents[node] = -2;
        for(int i=0;i<N;i++){
            if(parents[i]==node){
                deleteNode(i);
            }
        }
    }
}