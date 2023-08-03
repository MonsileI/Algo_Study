package Algorithm_fifth_week_2023_07.st;

import java.util.*;
import java.io.*;
public class st_로봇이지나간경로_Level_3 {
    static int N,M;
    static char[][]map;
    static int[]start;
    static char dir;
    static int len;
    static int[][]move = {{-2,0},{0,2},{2,0},{0,-2}};
    static int[][]bMove = {{-1,0},{0,1},{1,0},{0,-1}};
    static char[] chdir = {'^','>','v','<'};
    static class Node {
        int i ;int j; int dir;String str;

        public Node(int i, int j, int dir,String str) {
            this.i = i;
            this.j = j;
            this.dir = dir;
            this.str = str;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        start = new int[2];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j);
                if(map[i][j]=='#') len++;
            }
        }
        OuterLoop:
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]=='#'){
                    int cnt = 0;
                    for(int d=0;d<4;d++){
                        int ni = i + bMove[d][0];
                        int nj = j + bMove[d][1];
                        if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                        if(map[ni][nj]=='#') cnt++;
                        if(1<cnt) break;
                    }
                    if(cnt==1) {
                        start[0] = i;
                        start[1] = j;
                        break OuterLoop;
                    }
                }
            }
        }
        Node ans = bfs();
        StringBuilder sb = new StringBuilder();
        sb.append((start[0]+1)+" "+(start[1]+1)).append("\n");
        sb.append(dir).append("\n");
        sb.append(ans.str);
        System.out.println(sb.toString());
    }
    static Node bfs(){
        len--;
        Queue<Node> q = new ArrayDeque<>();
        boolean[][]visited = new boolean[N][M];
        visited[start[0]][start[1]] = true;
        q.offer(new Node(start[0],start[1],0,""));
        boolean flag = false;
        while(!q.isEmpty()){
            Node c = q.poll();
            int nowDir = c.dir;
            boolean check = false;
            if(len==0) {
                return c;
            }
            for(int d=0;d<4;d++){
                int ni = c.i + move[d][0];
                int nj = c.j + move[d][1];
                int si = c.i + bMove[d][0];
                int sj = c.j + bMove[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(!flag){
                    if(map[ni][nj]=='#' && !visited[ni][nj] && map[si][sj]=='#'){
                        visited[ni][nj] = true;
                        flag = true;
                        dir = chdir[d];
                        c.str += 'A';
                        len -=2;
                        q.offer(new Node(ni,nj,d,c.str));
                    }
                }else{
                    if(map[ni][nj]=='#' && !visited[ni][nj] && map[si][sj]=='#'){
                        visited[ni][nj] = true;
                        //L은 왼쪽 90도 R은 오른쪽 90도
                        if(nowDir==(d+1)%4) c.str += 'L';
                        else if(nowDir==(d+3)%4) c.str += 'R';
                        c.str += 'A';
                        len -=2;
                        q.offer(new Node(ni,nj,d,c.str));
                    }
                }

            }
        }
        return null;
    }
}
