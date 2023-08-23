package Algorithm_third_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_2252_줄세우기_Gold_3 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        List<List<Integer>> list = new ArrayList<>();
        int[] edgeCount = new int[N+1];
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list.get(from).add(to);
            edgeCount[to]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1;i<N+1;i++) if(edgeCount[i]==0) q.offer(i);
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            int Num = q.poll();
            sb.append(Num+" ");
            for(Integer next : list.get(Num)){
                edgeCount[next]--;
                if(edgeCount[next]==0){
                    q.offer(next);
                }
            }
        }

        System.out.println(sb.toString());
    }
}
