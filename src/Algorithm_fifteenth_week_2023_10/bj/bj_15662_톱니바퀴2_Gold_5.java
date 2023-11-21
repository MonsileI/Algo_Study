package Algorithm_fifteenth_week_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_15662_톱니바퀴2_Gold_5 {
    static int N;
    static int[][]top;
    static boolean[]check;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        top = new int[N][8];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<8;j++){
                top[i][j] = Integer.parseInt(str.charAt(j)+"");
            }
        }
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            check = new boolean[N];
            calc(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken()));
        }
        int answer=  0;
        for(int i=0;i<N;i++) if(top[i][0]==1) answer++;
        System.out.println(answer);

    }
    static void calc(int num, int turn){
        check[num] = true;
        //제일 왼쪽이면 오른쪽만
        if(num==0){
            if(top[num][2]!=top[num+1][6]&&!check[num+1]) calc(num+1,turn*-1);
        //제일 오른 쪽이면 왼쪽만
        }else if(num==N-1){
            if(top[num][6]!=top[num-1][2]&&!check[num-1]) calc(num-1,turn*-1);
        //나머지
        }else{
            if(top[num][2]!=top[num+1][6]&&!check[num+1]) calc(num+1,turn*-1);
            if(top[num][6]!=top[num-1][2]&&!check[num-1]) calc(num-1,turn*-1);
        }

        //회전시키기

        //시계방향 0 -> 1
        if(turn==1){
            int last = top[num][7];
            for(int i=7;0<i;i--){
                top[num][i] = top[num][i-1];
            }
            top[num][0] = last;
        //반시계방향
        }else{
            int zero = top[num][0];
            for(int i=0;i<7;i++){
                top[num][i] = top[num][i+1];
            }
            top[num][7] = zero;
        }

    }
}
