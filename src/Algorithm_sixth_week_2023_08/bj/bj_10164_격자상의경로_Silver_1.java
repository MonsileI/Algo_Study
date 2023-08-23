package Algorithm_sixth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_10164_격자상의경로_Silver_1 {

    static int N,M;
    static int goal[];
    static int[][]move = {{1,0},{0,1}};
    static int answer;
    static int [][]map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken()); int g = Integer.parseInt(st.nextToken());
        int idx = 1;
        map = new int[N][M];
        goal = new int[2];
        OuterLoop:
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                map[i][j] = idx;
                if(idx==g){goal[0] = i; goal[1] = j; break OuterLoop;}
                idx++;
            }
        }
        bfs();
        System.out.println(answer);
    }

    static void bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        if(goal[0]==0 &&goal[1]==0) q.offer(new int[]{0,0,1});
        else q.offer(new int[]{0,0,0});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int i = cur[0]; int j = cur[1]; int c = cur[2];
            if(i==N-1 && j==M-1){
                answer++;
                continue;
            }
            if((goal[0]<i||goal[1]<j)&&(c==0)) continue;
            for(int d=0;d<2;d++){
                int ni = i + move[d][0]; int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                int check = c;
                if(ni==goal[0] && nj==goal[1]) check = 1;
                q.offer(new int[]{ni,nj,check});

            }
        }
    }
}
