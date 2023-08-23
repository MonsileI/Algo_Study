package Algorithm_sixth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_1068_트리_Gold_5 {

    static int[]parents;
    static int N;
    static int head;
    static int answer;
    static boolean[]visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        parents = new int[N];

        for(int i=0;i<N;i++){
            int node = Integer.parseInt(st.nextToken());
            if(node==-1) head = i;
            else parents[i] = node;
        }

        deleteNode(Integer.parseInt(br.readLine()));
        visited = new boolean[N];
        countLeaf(head);
        System.out.println(answer);
    }

    static void countLeaf(int node){
        boolean isLeaf = true;
        visited[node] = true;
        if(parents[node]!=-2){
            for(int i=0;i<N;i++){
                if(parents[i]==node && !visited[i]){
                    visited[i] = true;
                    countLeaf(i);
                    isLeaf = false;
                }
            }
            if(isLeaf) answer++;
        }
    }
    static void deleteNode(int num){
        parents[num] = -2;
        for(int i=0;i<N;i++){
            if(parents[i]==num){
                deleteNode(i);
            }
        }

    }
}