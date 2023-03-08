package March_first;

import java.util.*;
import java.io.*;
public class bj_2174_로봇시뮬레이션_Gold_5 {

    static int map[][],N,M,RC,CC;
    static int[][]robot;

    static int[][]dir = {{-1,0},{0,1},{1,0},{0,-1}};
    static boolean flag;
    static StringBuilder sb = new StringBuilder();
    static void calc(int r,int d,int c){



        //d == L R F  L -> 0 -> 3  1-> 0  2-> 1  3-> 2
        //            R -> 0 -> 1  1-> 2  2-> 3  3-> 0
        // F -> move[d][0] , move[d][1]
        //벽을 넘어가는 경우,
        //다른 로봇에 충돌하는 경우
        for(int z=0;z<c;z++){

            int ni =0;
            int nj =0;
            int nd =0;
            if(d==0){
                nd = (robot[r][2] + 3) % 4;
                robot[r][2] = nd;
            }else if(d==1){
                nd = (robot[r][2] + 1) % 4;
                robot[r][2] = nd;
            }else{
                ni = robot[r][0] + dir[robot[r][2]][0];
                nj = robot[r][1] + dir[robot[r][2]][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj){
                    sb.append("Robot "+(r+1)+" crashes into the wall");
                    flag = true;
                    return;
                }
                for(int i = 0; i < RC ; i ++){
                    if(i==r) continue;
                    if(ni==robot[i][0] && nj==robot[i][1]){
                        sb.append("Robot "+(r+1)+" crashes into robot "+ (i+1));
                        flag = true;
                        return;
                    }
                }
                robot[r][0] = ni; robot[r][1] = nj;
            }



        }



    }

    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        RC = Integer.parseInt(st.nextToken());
        CC = Integer.parseInt(st.nextToken());

        flag = false;
        robot = new int[RC][3];
        //0 1 2 3 북 동 남 서
        for(int i=0;i<RC;i++){
            st =new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken())-1;
            int y = N-Integer.parseInt(st.nextToken());
            String a = st.nextToken();
            if(a.equals("N")) robot[i][2] = 0;
            else if(a.equals("E")) robot[i][2] = 1;
            else if(a.equals("S")) robot[i][2] = 2;
            else robot[i][2] = 3;
            robot[i][0] = y;
            robot[i][1] = x;
        }

        for(int i=0;i<CC;i++){
            st =new StringTokenizer(br.readLine()," ");
            int r = Integer.parseInt(st.nextToken())-1;
            int d = 0;
            String a = st.nextToken();
            if(a.equals("L")) d= 0;
            else if(a.equals("R")) d = 1;
            else if(a.equals("F")) d = 2;
            int c = Integer.parseInt(st.nextToken());

            calc(r,d,c);
            if(flag) break;
        }

        if(!flag) sb.append("OK");

        System.out.println(sb.toString());
    }
}
