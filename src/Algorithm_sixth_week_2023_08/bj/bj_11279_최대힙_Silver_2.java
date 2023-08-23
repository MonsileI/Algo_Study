package Algorithm_sixth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_11279_최대힙_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            if(num==0){
                if(pq.isEmpty()) sb.append(0+"\n");
                else sb.append(pq.poll()+"\n");
            }else pq.offer(num);
        }

        System.out.println(sb.toString());
    }
}
