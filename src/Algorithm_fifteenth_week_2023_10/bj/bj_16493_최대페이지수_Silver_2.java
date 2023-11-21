package Algorithm_fifteenth_week_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_16493_최대페이지수_Silver_2 {
    static class Node implements  Comparable<Node>{
        int cnt; int v;

        public Node(int cnt, int v) {
            this.cnt = cnt;
            this.v = v;
        }

        @Override
        public int compareTo(Node o) {
            return ((v/cnt) == (o.v/o.cnt)) ? -(cnt - o.cnt): -((v/cnt) - (o.v/o.cnt));
        }


        @Override
        public String toString() {
            return "Node{" +
                    "cnt=" + cnt +
                    ", v=" + v +
                    '}';
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        Node[]arr = new Node[N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int chap = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            arr[i] = new Node(chap,value);
        }
        Arrays.sort(arr);
        int answer=  0;
        for(int i=0;i<N;i++){
            if(D-arr[i].cnt<0) continue;
            answer += arr[i].v;
            D -= arr[i].cnt;
        }
        System.out.println(answer);
    }
}
