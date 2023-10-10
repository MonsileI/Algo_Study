package Algorithm_repeat_week_first_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_1987_알파벳_Gold_4 {
    static int N,M;
    static char[][]map;
    static int [][] move = {{-1,0},{0,1},{1,0},{0,-1}};
    static boolean[]visited;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for(int i=0;i<N;i++)map[i] = br.readLine().toCharArray();
        visited = new boolean[26];
        visited[map[0][0]-'A'] = true;
        dfs(1,0,0);
        System.out.println(answer);
    }
    static void dfs(int depth,int i,int j){

        answer = Math.max(answer,depth);

        for(int d=0;d<4;d++){
            int ni = i + move[d][0];
            int nj= j + move[d][1];
            if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
            if(!visited[map[ni][nj]-'A']){
                visited[map[ni][nj]-'A'] = true;
                dfs(depth+1,ni,nj);
                visited[map[ni][nj]-'A'] = false;
            }
        }

    }
}
