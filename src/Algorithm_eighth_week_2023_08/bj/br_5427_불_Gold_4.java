package Algorithm_eighth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class br_5427_불_Gold_4 {
    static int N,M;
    static char[][]map;
    static Queue<int[]> fires;
    static Queue<int[]> run;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int answer;
    static boolean flag;
    static boolean[][]visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb=  new StringBuilder();
        StringTokenizer st = null;
        for(int t=0;t<TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            map = new char[N][M];
            visited = new boolean[N][M];
            run = new ArrayDeque<>();
            fires = new ArrayDeque<>();
            for(int i=0;i<N;i++){
                String str= br.readLine();
                for(int j=0;j<M;j++){
                    map[i][j] = str.charAt(j);
                    if(map[i][j]=='@'){
                        run.offer(new int[]{i,j,0});
                        map[i][j] = '.';
                        visited[i][j] = true;
                    }else if(map[i][j]=='*') fires.offer(new int[]{i,j});
                }
            }
            answer=0;
            flag = false;
            bfs();
            if(flag) sb.append(answer+"\n");
            else sb.append("IMPOSSIBLE\n");
        }
        System.out.println(sb.toString());
    }
    static void bfs(){

        while(true){

            int runSize = run.size();
            int fireSize = fires.size();
            if(runSize==0) return;

            for(int f=0;f<fireSize;f++){
                int[]c = fires.poll();
                int i = c[0]; int j = c[1];
                for(int d=0;d<4;d++){
                    int ni = i + move[d][0];
                    int nj = j + move[d][1];
                    if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                    if(map[ni][nj]=='.'){
                        map[ni][nj] = '*';
                        fires.offer(new int[]{ni,nj});
                    }
                }
            }


            for(int r =0;r<runSize;r++){
                int[]c = run.poll();
                int i = c[0]; int j = c[1]; int cnt = c[2];

                for(int d=0;d<4;d++){
                    int ni = i + move[d][0];
                    int nj = j + move[d][1];
                    if(ni<0||nj<0||N-1<ni||M-1<nj){
                        answer = cnt+1;
                        flag =  true;
                        return;
                    }
                    if(!visited[ni][nj]&&map[ni][nj]=='.'){
                        visited[ni][nj] = true;
                        run.offer(new int[]{ni,nj,cnt+1});
                    }
                }
            }
        }

    }
}
