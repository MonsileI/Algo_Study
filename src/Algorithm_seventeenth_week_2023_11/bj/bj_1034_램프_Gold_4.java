package Algorithm_seventeenth_week_2023_11.bj;
import java.util.*;
import java.io.*;
public class bj_1034_램프_Gold_4 {
    static int[][]map;
    static int N,M;
    static boolean[]visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(str.charAt(j)+"");
            }
        }
        int K = Integer.parseInt(br.readLine());
        int c = K%2;
        visited = new boolean[N]; //그 행이 계산을 했는지 안했는지
        int ans = 0;
        for(int i=0;i<N;i++){
            int zero = 0;
            for(int j=0;j<M;j++) if(map[i][j]==0)zero++;
            if(visited[i]) continue;
            if(zero>K||zero%2!=c) continue;
            ans = Math.max(ans,check(i));
        }
        System.out.println(ans);

    }
    static int check(int idx){
        int tmp = 1;
        OuterLoop:
        for(int i=idx+1;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]!=map[idx][j]) continue OuterLoop;
            }
            visited[i] = true;
            tmp++;
        }

        return tmp;
    }
}
