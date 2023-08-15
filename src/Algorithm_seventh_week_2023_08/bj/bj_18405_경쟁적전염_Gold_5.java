package Algorithm_seventh_week_2023_08.bj;

import java.io.*;
import java.util.*;
public class bj_18405_경쟁적전염_Gold_5 {
    static int N,M,map[][];
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};

    static class Virus implements Comparable<Virus>{
        int i;int j;int v;int time;

        public Virus(int i, int j, int v,int time) {
            this.i = i;
            this.j = j;
            this.v = v;
            this.time = time;
        }

        @Override
        public int compareTo(Virus o) {
            return v - o.v;
        }

    }

    static Queue<Virus> q = new ArrayDeque<>();
    static boolean[][]visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];
        List<Virus> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]!=0) {
                    list.add(new Virus(i,j,map[i][j],0));
                }
            }
        }
        st = new StringTokenizer(br.readLine()," ");
        int t = Integer.parseInt(st.nextToken());
        int gi = Integer.parseInt(st.nextToken())-1;
        int gj = Integer.parseInt(st.nextToken())-1;

        Collections.sort(list);

        for(Virus virus : list) q.offer(new Virus(virus.i,virus.j,virus.v,0));
        bfs(t);
        System.out.println(map[gi][gj]);

    }
    static void bfs(int t){

        while(!q.isEmpty()){
            Virus virus = q.poll();
            int i = virus.i; int j = virus.j; int v = virus.v; int time = virus.time;
            if(time==t) return;
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                if(map[ni][nj]!=0) continue;
                map[ni][nj] = v;
                q.offer(new Virus(ni,nj,map[ni][nj],time+1));
            }
        }

    }
}
