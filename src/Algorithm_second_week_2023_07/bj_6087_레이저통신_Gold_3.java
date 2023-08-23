package Algorithm_second_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_6087_레이저통신_Gold_3 {

    static class Node {
        int i,j,cnt,dir;

        public Node(int i, int j, int cnt, int dir) {
            this.i = i;
            this.j = j;
            this.cnt = cnt;
            this.dir = dir;
        }


    }

    static int N,M;
    static char[][]map;
    static int si,sj,gi,gj,answer;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int[][]visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); N = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new int[N][M];
        boolean flag = true;
        for(int i=0;i<N;i++) {
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j);
                if(map[i][j]=='C'){
                    if(flag){
                        si = i; sj = j;
                        flag = false;
                    }else{
                        gi = i; gj = j;
                    }
                }
            }
        }

        bfs();
        System.out.println(answer);
    }
    static void bfs(){
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(si,sj,0,-1));
        visited[si][sj] = 1;
        while(!q.isEmpty()){
            Node cur = q.poll();
            int i = cur.i; int j = cur.j; int cnt = cur.cnt;

            if(i==gi&&j==gj){
                answer = Math.min(answer,cnt);
                continue;
            }
            for(int d=0;d<4;d++){
                int ni = i + move[d][0]; int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj||map[ni][nj]!='.') continue;
                int tmp = cnt+1;
                if(cur.dir==-1||cur.dir==d) tmp--;
                if(visited[ni][nj]==0){
                    visited[ni][nj] = tmp;
                    q.offer(new Node(ni,nj,tmp,d));
                }else if(visited[ni][nj]>=tmp){
                    visited[ni][nj] = tmp;
                    q.offer(new Node(ni,nj,tmp,d));
                }

            }
        }
    }
}
