package Algorithm_fourteenth_week_2023_10.gr;

import java.util.*;
import java.io.*;

public class gr_과일구매_Level_3 {


    static class Node implements Comparable<Node>{
        long happy; long cnt; //포만감이랑 개수여야해 , 포만감 기준으로

        public Node(long happy, long cnt) {
            this.happy = happy;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return (int)-(happy - o.happy);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            long p = Long.parseLong(st.nextToken()); //가격
            long c = Long.parseLong(st.nextToken()); //포만감
            pq.offer(new Node((c/p),p));
        }
        long answer = 0;
        while(0<K&&!pq.isEmpty()){
            Node now = pq.poll();
            long happy = now.happy; //포만감
            long cnt = now.cnt; //개수
            if(0<=K-cnt){
                answer += (happy*cnt);
                K -= cnt;
                continue;
            }else{
                answer += happy;
                K--;
                cnt--;
                if(K==0) break;
                if(cnt==0) continue;
            }
        }
        System.out.println(answer);
    }
}
