package Algorithm_seventh_week_2023_08.pr;

import java.util.*;
public class pr_양과늑대_Level_3 {

    static int [] I;
    static int[][] E;

    static int answer = 0;

    public static void main(String[] args) {
        int[]info = {0,0,1,1,1,0,1,0,1,0,1,1};
        int[][]edge = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
        I = info; E = edge;
        boolean[] visited = new boolean[info.length];
        dfs(0,0,visited,0);
        System.out.println(answer);

    }
    static void dfs(int s,int w,boolean[]visited,int node){
        visited[node] = true;
        if(I[node]==0){
            s++;
            answer = Math.max(answer,s);
        }else{
            w++;
            if(s<=w) return;
        }

        for(int [] edge : E){
            if(visited[edge[0]] && !visited[edge[1]]){
                boolean[]nextVisited = new boolean[visited.length];
                for(int i=0;i<visited.length;i++){
                    nextVisited[i] = visited[i];
                }
                dfs(s,w,nextVisited,edge[1]);
            }
        }

    }
}
