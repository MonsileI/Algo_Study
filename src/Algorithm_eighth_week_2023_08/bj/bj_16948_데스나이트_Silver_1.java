package Algorithm_eighth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_16948_데스나이트_Silver_1 {

    static int N;
    static int[][]map;

    static int answer;

    static int [][]move = {{-2,-1},{-2,1},{0,-2},{0,2},{2,-1},{2,1}};

    /*
    r-2, c-1), (r-2, c+1), (r, c-2), (r, c+2), (r+2, c-1), (r+2, c+1
    * */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        int si = Integer.parseInt(st.nextToken());
        int sj = Integer.parseInt(st.nextToken());
        int ei = Integer.parseInt(st.nextToken());
        int ej = Integer.parseInt(st.nextToken());
        bfs(si,sj,ei,ej);
        System.out.println(answer==0 ? -1 : answer);
    }
    static void bfs(int y,int x,int ei,int ej){
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][]visited = new boolean[N][N];
        q.offer(new int[]{y,x,0});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j =c[1]; int cnt = c[2];
            if(i==ei&&j==ej){
                answer = cnt;
                return;
            }
            for(int d=0;d<6;d++){
                int ni = i + move[d][0]; int nj =  j + move[d][1];
                if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                if(!visited[ni][nj]){
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj,cnt+1});
                }
            }

        }
    }
}
