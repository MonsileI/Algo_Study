package Algorithm_nineteenth_week_2023_11.bj;
import java.util.*;
import java.io.*;
public class bj_1766_문제집_Gold_2 {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[]dist = new int[N+1];
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st =new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dist[b]++;
            list.get(a).add(b);
        }
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq=  new PriorityQueue<>();
        for(int i=1;i<N+1;i++){
            if(dist[i]==0) pq.offer(i);
        }
        while(!pq.isEmpty()){
            int node = pq.poll();
            sb.append(node+" ");
            for(int next : list.get(node)){
                dist[next]--;
                if(dist[next]==0){
                    pq.offer(next);
                }
            }
        }
        System.out.println(sb.toString());
    }
}
