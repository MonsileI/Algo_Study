package May_Fifth.bj;

import java.io.*;
import java.util.*;

public class bj_13335_트럭_Silver_1_re {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); int W = Integer.parseInt(st.nextToken()); int L = Integer.parseInt(st.nextToken());

        Queue<Integer> q=  new ArrayDeque<>();
        Queue<Integer> truck = new ArrayDeque<>();
        st =new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) {truck.offer(Integer.parseInt(st.nextToken()));}
        for(int i=0;i<W;i++) q.offer(0);
        int answer = 0;
        int sum = 0;
        while(!q.isEmpty()){
            answer++;
            sum -= q.poll();
            if(!truck.isEmpty()){
                if(sum + truck.peek() < L){
                    sum += truck.peek();
                    q.offer(truck.poll());
                }else q.offer(0);
            }
        }
        System.out.println(answer);
    }
}
