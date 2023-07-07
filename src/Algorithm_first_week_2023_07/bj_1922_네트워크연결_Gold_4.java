package Algorithm_first_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_1922_네트워크연결_Gold_4 {

    static class Node implements Comparable<Node>{
        int start,end,weigth;

        public Node(int start, int end, int weigth) {
            this.start = start;
            this.end = end;
            this.weigth = weigth;
        }

        @Override
        public int compareTo(Node o) {
            return weigth - o.weigth;
        }
    }
    static int N;
    static int[]parent;
    static List<Node> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        Node[]netWork = new Node[M];
        for(int i=0;i<M;i++){
            st =new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            netWork[i] = new Node(start,end,weight);
        }
        Arrays.sort(netWork);
        parent = new int[N+1];
        for(int i=1;i<N+1;i++)parent[i] = i;
        int answer = 0;
        for(int i=0;i<M;i++){
            Node node = netWork[i];
            if(union(netWork[i].start,netWork[i].end)){
                answer += netWork[i].weigth;
            }
        }
        System.out.println(answer);
    }

    static boolean union(int from,int to){
        int rootA = find(from);
        int rootB = find(to);
        if(rootA!=rootB){
            parent[rootA] = rootB;
            return true;
        }
        return false;
    }
    static int find(int num){
        if(parent[num]==num) return num;
        return parent[num] = find(parent[num]);
    }
}
