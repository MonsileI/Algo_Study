package Algorithm_repeat_week_first_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_14502_연구소_Gold_4 {
    static List<int[]> list;
    static int N,M;
    static int[][]map;
    static int combN;
    static int[]tmp;
    static int answer;
    static boolean[][]visited;
    static int[][]copyMap;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        list = new ArrayList<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==0) list.add(new int[]{i,j});

            }
        }
        combN = list.size();
        tmp = new int[3];
        comb(0,0);
        System.out.println(answer);
    }
    static int bfs(int y,int x){
        int cnt = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y,x});
        visited[y][x] = true;
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0]; int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(!visited[ni][nj]&&copyMap[ni][nj]!=1){
                    if(copyMap[ni][nj]==0) cnt++;
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj});
                }
            }
        }
        return cnt;
    }
    static void calc(){
        copyMap = new int[N][M];
        for(int i=0;i<N;i++) for(int j=0;j<M;j++)copyMap[i][j] = map[i][j];
        int totalZero = combN-3; //벽 세개 세우니까 -3 해줌
        for(int i=0;i<3;i++){
            int[]v = list.get(tmp[i]);
            copyMap[v[0]][v[1]]= 1;
        }
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j]&&copyMap[i][j]==2){
                    totalZero -= bfs(i,j);
                }
                if(totalZero<=answer) return;
            }
        }
        answer = totalZero;
    }
    static void comb(int depth,int start){

        if(depth==3){
            calc();
            return;
        }

        for(int i=start;i<combN;i++){
            tmp[depth] = i;
            comb(depth+1,i+1);
        }
    }
}
