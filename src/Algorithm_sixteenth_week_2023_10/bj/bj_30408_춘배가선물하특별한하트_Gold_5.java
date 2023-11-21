package Algorithm_sixteenth_week_2023_10.bj;
import java.util.*;
import java.io.*;
public class bj_30408_춘배가선물하특별한하트_Gold_5 {


    static class Node{
        long now; int cnt;

        public Node(long now, int cnt) {
            this.now = now;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        Queue<Node> q =new ArrayDeque<>();
        q.offer(new Node(M,0));
        int[]dp = new int[1000001];
        dp[0] = 0;
        dp[1] = 1;
        int num = 2;
        for(int i=2;i<1000000;i++) dp[i] = dp[i-1] + num++;
        boolean flag = false;
        //13 4 의 경우, 2번 x할때 3을 빼줘야 됨.
        //다음은 6번? 그다음은 10번?
        //32 일경우 26이거든?
        while(!q.isEmpty()){
            Node c = q.poll();
            long now = c.now;
            int count = c.cnt;
            if(now==N || now-dp[count]==N){
                flag = true;
                break;
            }

            if(now*2<=N+dp[count+1]){
                q.offer(new Node(now*2,count+1));
            }

        }
        System.out.println(flag ? "YES" : "NO");
    }
}
