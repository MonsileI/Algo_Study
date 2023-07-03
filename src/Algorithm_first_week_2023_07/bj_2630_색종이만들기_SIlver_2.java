package Algorithm_first_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_2630_색종이만들기_SIlver_2 {
    static int N;
    static int[]answer;
    static int[][]map;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st = null;
        answer = new int[2];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0,N,map[0][0]);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }
    static boolean check(int i,int j,int size,int num){

        for(int x=i;x<size+i;x++){
            for(int y=j;y<size+j;y++){
                if(map[x][y]!=num) return false;
            }
        }

        return true;
    }
    static void dfs(int i,int j,int size,int num){

        if(check(i,j,size,num)){
            answer[num]++;
            return;
        }

        dfs(i,j,size/2,map[i][j]);
        dfs(i+size/2,j,size/2,map[i+size/2][j]);
        dfs(i,j+size/2,size/2,map[i][j+size/2]);
        dfs(i+size/2,j+size/2,size/2,map[i+size/2][j+size/2]);


    }
}
