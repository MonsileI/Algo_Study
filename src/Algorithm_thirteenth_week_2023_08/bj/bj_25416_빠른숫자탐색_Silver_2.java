package Algorithm_thirteenth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_25416_빠른숫자탐색_Silver_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = 5;
        int[][]map = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int si = Integer.parseInt(st.nextToken()); int sj = Integer.parseInt(st.nextToken());
        boolean[][]visited = new boolean[N][N];
        visited[si][sj] = true;
        int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{si,sj,0});
        int answer = 987654321;
        while(!q.isEmpty()){
            int []c = q.poll();
            int i = c[0]; int j = c[1]; int cnt = c[2];
            if(map[i][j]==1){
                answer = cnt;
                break;
            }
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                if(!visited[ni][nj]&&map[ni][nj]!=-1){
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj,cnt+1});
                }
            }
        }
        System.out.println(answer==987654321 ? -1 : answer);
    }
}
