package Algorithm_twenty_week_2023_12.bj;
import java.util.*;
import java.io.*;
public class bj_7569_토마토_Gold_5 {
    static int N,M,H;
    static boolean flag = true;
    static int[][][]map;
    static int[][]move = {{-1,0,0},{0,1,0},{1,0,0},{0,-1,0},{0,0,-1},{0,0,1}};
    static int count;
    static Queue<int[]> q = new ArrayDeque<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[N][M][H];
        for(int k=0;k<H;k++){
            for(int i=0;i<N;i++){
                st =new StringTokenizer(br.readLine()," ");
                for(int j=0;j<M;j++){
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if(map[i][j][k]==1) q.offer(new int[]{i,j,k});
                    else if(map[i][j][k]==0) count++;
                }
            }
        }
        int ans = 0;
        while(true){
            if(count==0) break;
            ans++;
            flag = false;
            calc();
            if(!flag) break;
        }
        System.out.println(!flag ? -1 : ans);
    }

    static void calc(){
        int size = q.size();
        for(int tc = 0 ; tc <size ;tc++){
            int[]c = q.poll();
            int i = c[0]; int j =  c[1]; int h = c[2];
            for(int d=0;d<6;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                int nh = h + move[d][2];

                if(ni<0||nj<0||nh<0||N-1<ni||M-1<nj||H-1<nh) continue;
                if(map[ni][nj][nh]==0){
                    map[ni][nj][nh]=1;
                    count--;
                    flag= true;
                    q.offer(new int[]{ni,nj,nh});
                }
            }
        }
    }
}
