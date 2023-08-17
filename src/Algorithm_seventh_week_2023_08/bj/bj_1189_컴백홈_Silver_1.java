package Algorithm_seventh_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_1189_컴백홈_Silver_1 {
    static int N,M,K;
    static int answer;
    static int gi,gj;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static char[][]map;
    static boolean[][]visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        gi = 0; gj = M-1;
        map = new char[N][M];
        for(int i=0;i<N;i++) map[i] = br.readLine().toCharArray();
        visited = new boolean[N][M];
        visited[N-1][0] = true;
        dfs(N-1,0,1);
        System.out.println(answer);
    }
    static void dfs(int i,int j,int depth){
        if(K<depth) return;
        if(i==gi&&j==gj){
            if(depth==K) answer++;
            return;
        }

        for(int d=0;d<4;d++){
            int ni = i + move[d][0];
            int nj = j + move[d][1];
            if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
            if(!visited[ni][nj]&&map[ni][nj]!='T'){
                visited[ni][nj] = true;
                dfs(ni,nj,depth+1);
                visited[ni][nj] = false;
            }
        }

    }

}
