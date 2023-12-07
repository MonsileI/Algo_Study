package Algorithm_twenty_week_2023_12.gr;
import java.sql.SQLOutput;
import java.util.*;
import java.io.*;
public class gr_연결요소제거하기_Level_3 {
    static char[][]map;
    static int N;
    static int K;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        map = new char[N][N];
        for(int i=0;i<N;i++)map[i] = br.readLine().toCharArray();
        for(int i=0;i<Q;i++){
            st = new StringTokenizer(br.readLine()," ");
            int y = Integer.parseInt(st.nextToken())-1;
            int x = Integer.parseInt(st.nextToken())-1;
            char ch = st.nextToken().charAt(0);
            map[y][x] = ch;
            bfs(y,x,ch);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static void bfs(int y,int x,char ch){
        boolean[][]visited= new boolean[N][N];
        visited[y][x] = true;
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{y,x});
        List<int[]> list = new ArrayList<>();
        int cnt = 1;
        list.add(new int[]{y,x});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                if(!visited[ni][nj]&& map[ni][nj]==ch){
                    cnt++;
                    list.add(new int[]{ni,nj});
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj});
                }

            }
        }
        if(cnt>=K) for(int[] i : list) map[i[0]][i[1]] = '.';
    }
}
