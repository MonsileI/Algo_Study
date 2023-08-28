package Algorithm_eighth_week_2023_08.st;

import java.util.*;
import java.io.*;
public class st_출퇴근길_Level_3 {
    static int N;
    static List<List<Integer>> list;
    static boolean[] v1;
    static boolean[] v2;
    static int sNode,eNode;
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        int M = Integer.parseInt(st.nextToken());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list.get(from).add(to);
        }
        st = new StringTokenizer(br.readLine()," ");
        sNode = Integer.parseInt(st.nextToken());
        eNode = Integer.parseInt(st.nextToken());
        sbfs();
        ebfs();

        for(int i=1;i<N+1;i++){
            if(i==sNode||i==eNode) continue;
            if(v1[i]&&v2[i]) answer++;
        }
        System.out.println(answer);
    }
    static void ebfs(){
        v2 = new boolean[N+1];
        v2[eNode] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(eNode);
        while(!q.isEmpty()){
            int now = q.poll();
            for(int next : list.get(now)){
                if(next==sNode) continue;
                if(!v2[next]){
                    v2[next] = true;
                    q.offer(next);
                }
            }
        }
    }
    static void sbfs(){
        v1 = new boolean[N+1];
        v1[sNode] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(sNode);
        while(!q.isEmpty()){
            int now = q.poll();
            for(int next : list.get(now)){
                if(next==eNode) continue;
                if(!v1[next]){
                    v1[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}
