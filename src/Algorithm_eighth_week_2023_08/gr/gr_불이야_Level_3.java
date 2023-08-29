package Algorithm_eighth_week_2023_08.gr;

import java.util.*;
import java.io.*;
public class gr_불이야_Level_3 {
    static int N,M;
    static char[][]map;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        int si = 0; int sj = 0;
        Queue<int[]> q= new ArrayDeque<>();
        boolean[][]visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j);
                if (map[i][j] == '&') {
                    si = i; sj = j;
                }else if(map[i][j]=='@'){
                    visited[i][j] = true;
                    q.offer(new int[]{i,j,0});
                }
            }
        }
        int[][]move= {{-1,0},{0,1},{1,0},{0,-1}};
        int answer=  -1;
        while(!q.isEmpty()){
            int []c = q.poll();
            int i = c[0]; int j = c[1]; int cnt = c[2];
            if(map[i][j]=='&'){
                answer = cnt-1;
                break;
            }
            for(int d=0;d<4;d++){
                int ni = i + move[d][0]; int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(!visited[ni][nj]&& map[ni][nj]!='#'){
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj,cnt+1});
                }
            }
        }
        System.out.println(answer);
    }
}
