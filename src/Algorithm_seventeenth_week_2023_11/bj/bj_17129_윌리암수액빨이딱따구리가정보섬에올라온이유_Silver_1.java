package Algorithm_seventeenth_week_2023_11.bj;
import java.util.*;
import java.io.*;
public class bj_17129_윌리암수액빨이딱따구리가정보섬에올라온이유_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int si = 0; int sj = 0;
        char[][]map = new char[N][M];
        boolean[][]visited=  new boolean[N][M];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j);
                if(map[i][j]=='2'){
                    si = i;
                    sj = j;
                }
            }
        }
        int ans = -1;
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{si,sj,0});
        visited[si][sj] = true;
        int[][]move= {{-1,0},{0,1},{1,0},{0,-1}};
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1]; int cnt = c[2];
            if(map[i][j]=='3'||map[i][j]=='4'||map[i][j]=='5'){
                ans = cnt;
                break;
            }
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(!visited[ni][nj]&&map[ni][nj]!='1'){
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj,cnt+1});
                }
            }
        }
        if(ans==-1) System.out.println("NIE");
        else{
            System.out.println("TAK");
            System.out.println(ans);
        }
    }
}
