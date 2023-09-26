package Algorithm_twelveth_week_2023_09.bj;

import java.util.*;
import java.io.*;
public class bj_3980_선발명단_Gold_5 {

    static int[][]map;
    static int answer;
    static boolean[]visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<TC;t++){
            answer = 0;
            map = new int[11][11];
            visited = new boolean[11];
            for(int i=0;i<11;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<11;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dfs(0,0);
            sb.append(answer+"\n");
        }
        System.out.println(sb.toString());
    }
    static void dfs(int depth,int sum){

        if(depth==11){
            answer = Math.max(answer,sum);
            return;
        }

        for(int i=0;i<11;i++){
            if(!visited[i] && map[i][depth]!=0){
                visited[i] = true;
                dfs(depth+1,sum + map[i][depth]);
                visited[i] = false;
            }
        }

    }
}
