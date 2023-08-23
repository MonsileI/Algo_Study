package Algorithm_seventh_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_2194_유닛이동시키기_Gold_5 {
    static int N,M,map[][];
    static int A,B;
    static int ei,ej;
    static int answer;
    static boolean[][]visited;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken()); B = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0;i<K;i++) {
            st =new StringTokenizer(br.readLine()," ");
            int f = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken())-1;
            map[f][s] = -1;
        }

        st = new StringTokenizer(br.readLine()," ");
        int si = Integer.parseInt(st.nextToken())-1;
        int sj = Integer.parseInt(st.nextToken())-1;
        st = new StringTokenizer(br.readLine()," ");
        ei = Integer.parseInt(st.nextToken())-1;
        ej = Integer.parseInt(st.nextToken())-1;
        visited = new boolean[N][M];
        if(si==ei&&sj==ej) System.out.println(0);
        else{
            bfs(si,sj);
            System.out.println(answer==0 ? -1 : answer);
        }

    }
    static void bfs(int si,int sj){
        visited[si][sj] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{si,sj,0});
        while(!q.isEmpty()){
            int []c = q.poll();
            int i = c[0];
            int j = c[1];
            int cnt= c[2];
            if(i==ei&&j==ej) {
                answer = cnt;
                return;
            }
            for(int d=0;d<4;d++){
                int ni = i+ move[d][0];
                int nj = j+ move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj||visited[ni][nj]) continue;
                boolean flag = true;
                OuterLoop:
                for(int a=i;a<A+i;a++){
                    for(int b=j;b<B+j;b++){
                        ni = a;
                        nj = b;
                        if(ni<0||nj<0||N-1<ni||M-1<nj) {
                            flag = false;
                            break OuterLoop;
                        }
                        if(map[ni][nj]==-1){
                            flag =  false;
                            break OuterLoop;
                        }
                    }
                }
                if(flag){
                    ni = i + move[d][0];
                    nj = j + move[d][1];
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj,cnt+1});
                }
            }
        }
    }
}
