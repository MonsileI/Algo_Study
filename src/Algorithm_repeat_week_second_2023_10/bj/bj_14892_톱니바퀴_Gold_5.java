package Algorithm_repeat_week_second_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_14892_톱니바퀴_Gold_5 {
    static int [][]top;
    static boolean[]check;

    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        top = new int[4][8];
        for(int i=0;i<4;i++){
            String str = br.readLine();
            for(int j=0;j<8;j++){
                top[i][j] = Integer.parseInt(str.charAt(j)+"");
            }
        }
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        while(0<N){
            st = new StringTokenizer(br.readLine()," ");
            int num = Integer.parseInt(st.nextToken())-1;
            int dir = Integer.parseInt(st.nextToken());
            check = new boolean[4];
            calc(num,dir);
            N--;

        }
        int ans = 0;
        for(int i=0;i<4;i++){
            if(top[i][0]==1){
                ans += Math.pow(2,i);
            }
        }
        System.out.println(ans);
    }
    static void calc(int num , int dir){
        //2랑 6 확인하면 됨
        check[num] = true;
        if(num==0){
            //오른쪽만 확인
            if(top[num+1][6]!=top[num][2]&&!check[num+1])calc(num+1,dir*-1);
        }else if(num==3){
            //왼쪽만 확인
            if(top[num][6]!=top[num-1][2]&&!check[num-1])calc(num-1,dir*-1);
        }else{
            if(top[num+1][6]!=top[num][2]&&!check[num+1])calc(num+1,dir*-1);
            if(top[num][6]!=top[num-1][2]&&!check[num-1])calc(num-1,dir*-1);
        }
        //회전
        if(dir==1){
          //시계방향
          int tmp = top[num][7];
          for(int i=7;0<i;i--) top[num][i] = top[num][i-1];
          top[num][0] = tmp;
        }else{
          //반시계방향
            int tmp = top[num][0];
            for(int i=1;i<8;i++) top[num][i-1] = top[num][i];
            top[num][7] = tmp;
        }

    }
}
