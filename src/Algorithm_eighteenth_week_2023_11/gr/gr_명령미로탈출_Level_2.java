package Algorithm_eighteenth_week_2023_11.gr;
import java.util.*;
import java.io.*;
public class gr_명령미로탈출_Level_2 {
    public static void main(String[] args)throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        int[][]map = new int[N][N];
        char[]order = br.readLine().toCharArray();
        int si =0; int sj = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1){
                    si = i; sj = j;
                    map[i][j] = 0;
                }
            }
        }
        //3은 벽, 2는 도착 , 최종 도착까지 몇번 명령 수행했는지,
        boolean flag = false;
        int cnt = 0;
        int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
        OuterLoop:
        for(int i=0;i<M;i++){
            char ch =order[i];
            int ni = 0; int nj = 0;
            switch (ch){
                case'U': ni = si + move[0][0]; nj = sj + move[0][1];
                    if(ni<0||nj<0||N-1<ni||N-1<nj) break;
                    if(map[ni][nj]==3) break;
                    if(map[ni][nj]==2){
                        cnt++;
                        flag = true;
                        break OuterLoop;
                    }
                    si = ni; sj = nj;
                    cnt++;
                    break;
                case'R': ni = si + move[1][0]; nj = sj + move[1][1];
                    if(ni<0||nj<0||N-1<ni||N-1<nj) break;
                    if(map[ni][nj]==3) break;
                    if(map[ni][nj]==2){
                        cnt++;
                        flag = true;
                        break OuterLoop;
                    }
                    si = ni; sj = nj;
                    cnt++;
                    break;

                case'D': ni = si + move[2][0]; nj = sj + move[2][1];
                    if(ni<0||nj<0||N-1<ni||N-1<nj) break;
                    if(map[ni][nj]==3) break;
                    if(map[ni][nj]==2){
                        cnt++;
                        flag = true;
                        break OuterLoop;
                    }
                    si = ni; sj = nj;
                    cnt++;
                    break;

                case'L': ni = si + move[3][0]; nj = sj + move[3][1];
                    if(ni<0||nj<0||N-1<ni||N-1<nj) break;
                    if(map[ni][nj]==3) break;
                    if(map[ni][nj]==2){
                        cnt++;
                        flag = true;
                        break OuterLoop;
                    }
                    si = ni; sj = nj;
                    cnt++;
                    break;
            }
        }
        System.out.println(!flag ? "FAIL" : "SUCCESS "+cnt);
    }
}
