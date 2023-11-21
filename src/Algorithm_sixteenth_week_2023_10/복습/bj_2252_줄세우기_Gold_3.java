package Algorithm_sixteenth_week_2023_10.복습;
import java.util.*;
import java.io.*;
public class bj_2252_줄세우기_Gold_3 {

    static int []dist;
    static List<List<Integer>> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N  =Integer.parseInt(st.nextToken());
        int M  =Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        dist = new int[N+1];
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            dist[b]++;
        }
        Queue<Integer> q=  new ArrayDeque<>();
        StringBuilder sb= new StringBuilder();
        for(int i=1;i<N+1;i++)  if(dist[i]==0) q. offer(i);
        while(!q.isEmpty()){
            int now = q.poll();
            sb.append(now+" ");
            for(int next : list.get(now)){
                dist[next]--;
                if(dist[next]==0){
                    q.offer(next);
                }
            }
        }
        System.out.println(sb.toString());
    }
}

