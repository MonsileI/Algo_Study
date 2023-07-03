package January_Fourth;

import java.util.*;
import java.io.*;
public class bj_14503_로봇청소기_Gold_5 {
    static int N,M,map[][];
    static int answer,si,sj,sd;
    static int [][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        answer = 0;
        st = new StringTokenizer(br.readLine());
        si = Integer.parseInt(st.nextToken()); sj = Integer.parseInt(st.nextToken()); sd = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            //현재칸 청소
            fir();
            //4칸 중 청소되지 않은 빈 칸이 없다. ->2번으로
            //4칸 중 청소되지 않은 빈 칸이 있다. ->3번으로
            if(!check()) {
                if(sec()) continue;
                else break;
            }else thi();
            /*for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println("=================");*/
        }
        System.out.println(answer);

    }
    static void thi(){
        //0 -> 3 || 1 -> 0 || 2 -> 1 || 3 -> 2
        int ns = (sd+3) % 4;
        sd = ns;
        int ni = si + move[sd][0]; int nj = sj + move[sd][1];
        if(map[ni][nj]==0) {
            si = ni;
            sj = nj;
        }

    }
    static boolean sec(){
        // 0 -> 2 || 2-> 0 || 1->3 || 3->1
        int ns = (sd+2) % 4;
        int ni = si + move[ns][0];
        int nj = sj + move[ns][1];
        if(ni<0||nj<0||N-1<ni||M-1<nj) return false;
        if(map[ni][nj]==1) return false;
        si = ni; sj = nj;
        return true;
    }
    static boolean check(){
        for(int d=0;d<4;d++){
            int ni = si + move[d][0]; int nj = sj + move[d][1];
            if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
            if(map[ni][nj]==0) return true;
        }
        return false;
    }

    static void fir(){
        if(map[si][sj]==0) {
            answer++;
            map[si][sj] = 2;
        }
    }
}
