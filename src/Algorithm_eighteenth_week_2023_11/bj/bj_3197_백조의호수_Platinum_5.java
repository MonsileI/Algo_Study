package Algorithm_eighteenth_week_2023_11.bj;

import java.util.*;
import java.io.*;
public class bj_3197_백조의호수_Platinum_5 {
    static class Node implements Comparable<Node>{
        int i;int j;int cnt;

        public Node(int i, int j, int cnt) {
            this.i = i;
            this.j = j;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return cnt - o.cnt;
        }
    }
    static int N,M;
    static char[][]map;
    static int si,sj;
    static int ei,ej;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int L  = 0 ;int R = 0;
        map = new char[N][M];
        boolean flag = false;
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j);
                if(map[i][j]=='L'&&!flag){
                    si = i; sj = j; flag = true;
                    map[i][j]='.';
                }
                if(map[i][j]=='L'&&flag){
                    ei = i; ej = j;
                    map[i][j]='.';
                }
                if(map[i][j]=='X') R++;
            }
        }
        while(L<R){
            int mid = (L+R)/2;
            if(check(mid)) R = mid;
            else L = mid+1;

        }
        int ans = L/2;
        if(L%2==1) ans++;
        System.out.println(ans);
    }
    static boolean check(int mid){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(si,sj,0));
        boolean[][]visited = new boolean[N][M];
        while(!pq.isEmpty()){
            Node now = pq.poll();
            int i = now.i; int j = now.j; int cnt = now.cnt;
            if(visited[i][j]) continue;
            visited[i][j] = true;
            if(i==ei&&j==ej) return true;
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(map[ni][nj]=='X'&&cnt<mid) pq.offer(new Node(ni,nj,cnt+1));
                else if(map[ni][nj]=='.'&&cnt<=mid)pq.offer(new Node(ni,nj,cnt));

            }
        }

        return false;
    }
}
