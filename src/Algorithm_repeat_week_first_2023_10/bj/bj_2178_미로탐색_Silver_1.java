package Algorithm_repeat_week_first_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_2178_미로탐색_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        int[][]map = new int[N][M];
        Queue<int[]> q = new ArrayDeque<>();
        int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(str.charAt(j)+"");
            }
        }
        q.offer(new int[]{0,0,1});
        int answer = 0;
        boolean[][]visited=  new boolean[N][M];
        visited[0][0] = true;
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1]; int cnt = c[2];
            if(i==N-1&&j==M-1){
                answer= cnt;
                break;
            }
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj= j  + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(!visited[ni][nj]&&map[ni][nj]==1){
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj,cnt+1});
                }
            }
        }
        System.out.println(answer);
    }
}
