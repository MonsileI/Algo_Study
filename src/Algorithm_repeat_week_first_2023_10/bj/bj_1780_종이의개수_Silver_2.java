package Algorithm_repeat_week_first_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_1780_종이의개수_Silver_2 {
    static int[][]map;
    static int zero,one,minus;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st=  null;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0,N,map[0][0]);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(one);
    }
    static void dfs(int y,int x,int size,int num){

        if(check(y,x,size,num)) return;


        dfs(y,x,size/3,map[y][x]);
        dfs(y+(size/3),x,size/3,map[y+(size/3)][x]);
        dfs(y+(size/3)*2,x,size/3,map[y+(size/3)*2][x]);

        dfs(y,x+(size/3),size/3,map[y][x+(size/3)]);
        dfs((y+size/3),x+(size/3),size/3,map[y+(size/3)][x+(size/3)]);
        dfs(y+(size/3)*2,x+(size/3),size/3,map[y+(size/3)*2][x+(size/3)]);

        dfs(y,x+(size/3)*2,size/3,map[y][x+(size/3)*2]);
        dfs(y+(size/3),x+(size/3)*2,size/3,map[y+(size/3)][x+(size/3)*2]);
        dfs(y+(size/3)*2,x+(size/3)*2,size/3,map[y+(size/3)*2][x+(size/3)*2]);


    }

    static boolean check(int y,int x,int size,int num){

        for(int i=y;i<y+size;i++){
            for(int j=x;j<x+size;j++){
                if(map[i][j]!=num) return false;
            }
        }
        if(num==-1) minus++;
        else if(num==0) zero++;
        else one++;
        return true;
    }
}
