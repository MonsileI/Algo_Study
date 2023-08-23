package Algorithm_second_week_2023_07;

import java.io.*;
import java.util.*;

public class bj_1992_쿼드트리_Silver_1 {
    static int N,map[][];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(""+str.charAt(j));
            }
        }
        dfs(0,0,N);
        System.out.println(sb.toString());
    }
    static boolean check(int i,int j,int size){
        for(int x=i;x<size+i;x++){
            for(int y=j;y<size+j;y++){
                if(map[i][j]!=map[x][y]) return false;
            }
        }
        return true;
    }
    static void dfs(int i,int j,int size){

        if(check(i,j,size)){
            sb.append(map[i][j]);
            return;
        }

        sb.append("(");

        dfs(i,j,size/2);
        dfs(i,j+size/2,size/2);
        dfs(i+size/2,j,size/2);
        dfs(i+size/2,j+size/2,size/2);

        sb.append(")");
    }

}
