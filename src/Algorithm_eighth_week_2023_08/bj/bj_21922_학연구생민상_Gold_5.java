package Algorithm_eighth_week_2023_08.bj;

import java.util.*;
import java.io.*;
/*
    1
    ========
    0 ->  소멸
    1 -> 3
    2 ->  소멸
    3 -> 1

    2
    ========
    0 -> 2
    1 -> 소멸
    2 ->  0
    3 -> 소멸

    3
    ========
    0 ->  1
    1 -> 0
    2 ->  3
    3 -> 2

    4
    ========
    0 ->  3
    1 -> 2
    2 ->  1
    3 -> 0
    * */

public class bj_21922_학연구생민상_Gold_5 {
    static int N,M,map[][];
    static boolean[][]visited;
    static int[][]move= {{-1,0},{0,1},{1,0},{0,-1}};
    static List<int[]> air;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        air = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    air.add(new int[]{i,j});
                }
            }
        }
        int answer = 0;
        if (!air.isEmpty()) {
            for(int[] a : air) bfs(a[0], a[1]);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (visited[i][j]) answer++;
                }
            }
        }
        System.out.println(answer);
    }
    static void bfs(int si, int sj){
        visited[si][sj] = true;
        //visited 처리를 위해서 한방향씩 q를 돌자(어차피 순환하니까)
        for(int t=0;t<4;t++){
            Queue<int[]> q= new ArrayDeque<>();
            boolean[][]tmpVisited = new boolean[N][M];
            tmpVisited[si][sj] = true;
            q.offer(new int[]{si,sj,t}); //사방향을 따로따로 진행

            OuterLoop:
            while(!q.isEmpty()){
                int []c = q.poll();
                int i = c[0]; int j = c[1]; int d = c[2];
                int ni = i + move[d][0]; int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj||tmpVisited[ni][nj]) break;
                tmpVisited[ni][nj] = true;
                visited[ni][nj] = true;
                if(map[ni][nj]!=0||map[ni][nj]!=9){
                    switch (map[ni][nj]){
                        case 1: if(d==1) d=3;
                                else if(d==3) d=1;
                            break ;
                        case 2: if(d==0) d=2;
                                else if(d==2) d=0;
                            break;
                        case 3: if(d==0) d=1;
                                else if(d==1) d=0;
                                else if(d==2) d=3;
                                else if(d==3) d=2;
                            break;
                        case 4: if(d==0) d=3;
                                else if(d==1) d=2;
                                else if(d==2) d=1;
                                else if(d==3) d=0;
                            break;
                    }
                }


                q.offer(new int[]{ni,nj,d});
            }
        }
    }
}
