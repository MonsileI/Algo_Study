package Algorithm_fifteenth_week_2023_10.bj;
import java.util.*;
import java.io.*;
public class bj_27896_특별한서빙_Gold_5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        int sum = 0;
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> -(o1-o2));
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            pq.offer(num);
            sum += num;
            while(sum>=M){
                ans++;
                sum -= pq.poll()*2;
            }
        }
        System.out.println(ans);
    }
}
