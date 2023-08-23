package Algorithm_seventh_week_2023_08.bj;

import java.io.*;
import java.util.*;

public class bj_6118_숨바꼭질_Silver_1 {
    static int N;
    static List<List<Integer>> list;
    static int answerNode;
    static int maxCnt;
    static int sameCnt = 1;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list.get(from).add(to);
            list.get(to).add(from);
        }
        bfs();
        System.out.println(answerNode+" "+maxCnt+" "+sameCnt);
    }
    static void bfs(){
        boolean[]visited = new boolean[N+1];
        visited[1] = true;
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{1,1});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int now = c[0]; int cnt = c[1];
            for(int node : list.get(now)){
                if(!visited[node]){
                    visited[node] = true;
                    if(maxCnt<cnt){
                        maxCnt = cnt;
                        sameCnt = 1;
                        answerNode = node;
                    }else if(maxCnt==cnt){
                        if(node<answerNode) {
                            answerNode = node;
                        }
                        sameCnt++;
                    }
                    q.offer(new int[]{node,cnt+1});
                }
            }
        }

    }
}
