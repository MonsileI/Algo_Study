package Algorithm_sixth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class br_11286_절댓값힙_Silver_1 {

    static class Node implements Comparable<Node>{
        int num; int abV; //absolute value

        public Node(int num, int abV) {
            this.num = num;
            this.abV = abV;
        }

        @Override
        public int compareTo(Node o) {
            return abV == o.abV ? num - o.num : abV - o.abV;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            if(num==0){
                if(pq.isEmpty()) sb.append(0+"\n");
                else sb.append(pq.poll().num+"\n");
            }else pq.offer(new Node(num,Math.abs(num)));
        }
        System.out.println(sb.toString());
    }
}
