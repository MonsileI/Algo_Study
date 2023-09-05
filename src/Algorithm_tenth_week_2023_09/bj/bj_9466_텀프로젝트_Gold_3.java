package Algorithm_tenth_week_2023_09.bj;

import java.util.*;
import java.io.*;
public class bj_9466_텀프로젝트_Gold_3 {
    static int N;
    static int[]pos;
    static int answer;
    static boolean[]visited;
    static boolean[]subVisited;

    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        for(int t=0;t<TC;t++){
            N = Integer.parseInt(br.readLine());
            pos = new int[N+1];
            answer = 0;
            visited = new boolean[N+1];
            subVisited = new boolean[N+1];
            st = new StringTokenizer(br.readLine()," ");

            for(int i=1;i<N+1;i++){
                int to = Integer.parseInt(st.nextToken());
                pos[i] = to;
            }
            for(int i=1;i<N+1;i++){
                if(!subVisited[i]){
                    dfs(i);
                }
            }

            sb.append((N-answer)+"\n");
        }
        System.out.println(sb.toString());
    }
    static void dfs(int num){
        if(visited[num]){
            subVisited[num] = true;
            answer++;
        }else{
            visited[num] = true;
        }

        if(!subVisited[pos[num]]){
            dfs(pos[num]);
        }

        visited[num] = false;
        subVisited[num] = true;
    }
}
