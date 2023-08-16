package Algorithm_seventh_week_2023_08.gr;
import java.io.*;
import java.util.*;
public class gr_구름이의여행2_Level_3 {
    static int N;
    static int M;
    static List<List<Integer>> list;
    static int K;
    static int answer = 987654321;
    static Queue<int[]> q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new ArrayList();
        q = new ArrayDeque<>();
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list.get(from).add(to);
            if(from==K) q.offer(new int[]{to,1});
        }
        bfs();
        System.out.println(answer==987654321 ? -1 : answer);
    }
    static void bfs(){

        while(!q.isEmpty()){

            int[]c = q.poll();
            int now = c[0];
            int cnt = c[1];

            if(M<cnt) return;

            if(now==K){
                answer = cnt;
                return;
            }

            for(int next : list.get(now)){
                q.offer(new int[]{next,cnt+1});
            }
        }
    }
}