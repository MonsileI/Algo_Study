package Algorithm_eighteenth_week_2023_11.bj;

import java.util.*;
import java.io.*;
public class bj_21772_가희의고구마먹방_Gold_5 {

    static char[][]map;
    static int N,M;
    static int ans;
    static boolean[][]visited;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        int si = 0; int sj  =0;
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j);
                if(map[i][j]=='G'){
                    si = i; sj = j;
                    map[i][j] = '.';
                }
            }
        }
        visited = new boolean[N][M];
        dfs(si,sj,0,T);
        System.out.println(ans);
    }

    static void dfs(int i,int j,int cnt,int depth){
        if(depth==0) {
            ans = Math.max(ans, cnt);
            return;
        }

        for(int d=0;d<4;d++){
            int ni =  i + move[d][0]; int nj= j +move[d][1];
            if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
            if(map[ni][nj]!='#'){
                if(map[ni][nj]=='S'&&!visited[ni][nj]){
                    visited[ni][nj] = true;
                    dfs(ni,nj,cnt+1,depth-1);
                    visited[ni][nj] = false;
                }else dfs(ni,nj,cnt,depth-1);
            }
        }

    }
}
