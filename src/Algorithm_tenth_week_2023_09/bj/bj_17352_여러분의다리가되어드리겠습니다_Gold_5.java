package Algorithm_tenth_week_2023_09.bj;

import java.util.*;
import java.io.*;
public class bj_17352_여러분의다리가되어드리겠습니다_Gold_5 {
    static int N;
    static List<List<Integer>> list;
    static boolean[]visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = N-2;
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        if(N==2){
            sb.append("1 2");
        }else{
            list = new ArrayList<>();
            for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
            boolean flag = false;
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine()," ");
                int a= Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.get(a).add(b);
                list.get(b).add(a);
                if(a==1||b==1) flag = true;
            }
            visited=  new boolean[N+1];
            if(!flag) sb.append("1 2");
            else{
                sb.append("1 "+calc(1));
            }
        }
        System.out.println(sb.toString());

    }
    static int calc(int start){
        visited[start] = true;
        int res = 0;

        Queue<Integer> q= new ArrayDeque<>();
        q.add(start);
        while(!q.isEmpty()){
            int now = q.poll();
            for(int next : list.get(now)){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }

        for(int i=1;i<N+1;i++){
            if(!visited[i]){
                res = i;
                break;
            }
        }
        return res;

    }

}
