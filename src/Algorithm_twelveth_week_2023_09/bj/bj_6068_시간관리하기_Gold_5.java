package Algorithm_twelveth_week_2023_09.bj;

import java.util.*;
import java.io.*;
public class bj_6068_시간관리하기_Gold_5 {
    static class Node implements Comparable<Node>{
        int time; int end;

        public Node(int time, int end) {
            this.time = time;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            return end - o.end;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        PriorityQueue<Node> pq = new PriorityQueue();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            pq.offer(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        boolean flag = true;
        int minStart = Integer.MAX_VALUE;
        int total = 0;
        while(!pq.isEmpty()){
            Node now = pq.poll();
            total += now.time;
            minStart = Math.min(minStart,now.end - total);
            if(total > now.end){
                flag = false;
                break;
            }
        }
        if(!flag) minStart = -1;
        System.out.println(minStart);
    }
}
