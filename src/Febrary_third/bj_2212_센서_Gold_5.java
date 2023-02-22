package Febrary_third;

import java.util.*;
import java.io.*;
public class bj_2212_센서_Gold_5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++) pq.offer(Integer.parseInt(br.readLine()));

        while(1<pq.size()){

            int first =  pq.poll();
            int second =  pq.poll();
            answer += first+second;
            pq.offer(first+second);

        }


        System.out.println(answer);

    }
}
