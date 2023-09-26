package Algorithm_ninth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_17836_공주님을구해라_Gold_5 {
    static int N;
    static int M;
    static int[][]map;
    static boolean[][]visited;
    static int T;

    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        int swordI =0 ; int swordJ = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                    swordI = i; swordJ =j;
                    map[i][j] = 0;
                }
            }
        }
        //그냥 도달하는 경우 계산
        int normal = bfs(N-1,M-1);
        //칼을 사용하는 경우 계산
        int sword = bfs(swordI,swordJ);
        // sword += Math.abs(swordI-(N-1)) + Math.abs(swordJ-(M-1));
       //normal이 -1인 경우, normal이 T보다 큰 경우, sword가 -1인 경우, sword가 T보다 큰경우, 아닌 경우
        if(normal==-1||T<normal){
            if(sword==-1) System.out.println("Fail");
            else{
                sword += Math.abs(swordI-(N-1)) + Math.abs(swordJ-(M-1));
                if(T<sword) System.out.println("Fail");
                else System.out.println(sword);
            }
        }else{
            if(sword==-1) System.out.println(normal);
            else {
                sword += Math.abs(swordI-(N-1)) + Math.abs(swordJ-(M-1));
                if(T<sword) System.out.println(normal);
                else {
                    sword = sword < normal ? sword : normal;
                    System.out.println(sword);
                }
            }
        }

    }
    static int bfs(int gi,int gj){

        visited = new boolean[N][M];
        visited[0][0] = true;
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{0,0,0});
        while(!q.isEmpty()){
            int []c = q.poll();
            int i = c[0]; int j = c[1]; int cnt = c[2];
            if(i==gi&&j==gj) return cnt;
            if(T<cnt) return -1;

            for(int d=0;d<4;d++){
                int ni = i + move[d][0]; int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(!visited[ni][nj]&&map[ni][nj]==0){
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj,cnt+1});
                }
            }

        }
        return -1;
    }
}
