package Algorithm_fifteenth_week_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_2623_음악프로그램_Gold_3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<List<Integer>> list = new ArrayList<>();
        int[]dist = new int[N+1];
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int num = Integer.parseInt(st.nextToken());
            int f= Integer.parseInt(st.nextToken());
            for(int j=1;j<num;j++){
                int s = Integer.parseInt(st.nextToken());
                list.get(f).add(s);
                dist[s]++;
                f = s;
            }
        }
        StringBuilder sb= new StringBuilder();
        Queue<Integer>  q = new ArrayDeque<>();
        for(int i=1;i<N+1;i++)if(dist[i]==0)q.offer(i);
        int size = 0;
        while(!q.isEmpty()){
            int now = q.poll();
            sb.append(now+"\n");
            size++;
            for(int next : list.get(now)){
                dist[next]--;
                if(dist[next]==0){
                    q.offer(next);
                }
            }
        }
        if(size!=N) System.out.println(0);
        else System.out.println(sb.toString());
    }
}
