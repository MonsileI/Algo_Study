package Algorithm_twenty_week_2023_12.bj;
import java.util.*;
import java.io.*;
public class bj_1655_가운데를말해요_Gold_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb=  new StringBuilder();
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((o1, o2) -> -(o1-o2));
        boolean flag = true;
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            if(flag) maxPQ.offer(num);
            else minPQ.offer(num);

            if(!minPQ.isEmpty()&&!maxPQ.isEmpty()){
                if(minPQ.peek() < maxPQ.peek()){
                    int tmp = minPQ.poll();
                    minPQ.offer(maxPQ.poll());
                    maxPQ.offer(tmp);
                }
            }
            flag = !flag;
            sb.append(maxPQ.peek()+"\n");
        }
        System.out.println(sb.toString());
    }
}
