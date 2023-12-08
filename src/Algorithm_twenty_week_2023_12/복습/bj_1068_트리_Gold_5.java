package Algorithm_twenty_week_2023_12.복습;
import java.util.*;
import java.io.*;
public class bj_1068_트리_Gold_5 {
    static int N;
    static int[]parent;
    static int answer;
    static boolean[]visited;
    public static void main(String[] args) throws Exception {

        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parent = new int[N];
        visited = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int head = 0;
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            if(num==-1) head = i;
            parent[i] = num;
        }
        int dnode = Integer.parseInt(br.readLine());
        deleteNode(dnode);
        checkLeafNode(head);
        System.out.println(answer);
    }
    static void checkLeafNode(int node){
        visited[node] = true;
        if(parent[node]==-2) return;
        boolean flag = true;
        for(int i=0;i<N;i++){
            if(!visited[i]&&parent[i]==node){
                flag = false;
                checkLeafNode(i);
            }
        }
        if(flag) answer++;
    }

    static void deleteNode(int node){
        parent[node] = -2;
        for(int i=0;i<N;i++) if(parent[i] == node) deleteNode(i);
    }
}
