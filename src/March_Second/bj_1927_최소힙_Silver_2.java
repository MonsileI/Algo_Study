package March_Second;

import java.util.*;
import java.io.*;
public class bj_1927_최소힙_Silver_2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            int num =Integer.parseInt(br.readLine());
            if(pq.isEmpty()){
                if(num==0) sb.append(0).append("\n");
                else pq.offer(num);
            }else{
                if(num==0) sb.append(pq.poll()).append("\n");
                else pq.offer(num);
            }
        }
        System.out.println(sb.toString());
    }
}
