package January_Fourth;

import java.util.*;
import java.io.*;
public class bj_1992_쿼드트리_Silver_1 {
    static int N,map[][];
    static String answer = "";
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(str.charAt(j)+"");
            }
        }
        dfs(N,0,0,map[0][0]);
        System.out.println(answer);

    }
    static boolean check(int size,int i,int j,int num){
        for(int x=i;x<size+i;x++){
            for(int y=j;y<size+j;y++){
                if(map[x][y]!=num) return false;
            }
        }
        return true;
    }
    static void dfs(int size,int i,int j,int num){

        if(check(size,i,j,num)){
            answer += num;
            return;
        }
        answer += "(";
        dfs(size/2,i,j,map[i][j]);
        dfs(size/2,i,j+size/2,map[i][j+size/2]);
        dfs(size/2,i+size/2,j,map[i+size/2][j]);
        dfs(size/2,i+size/2,j+size/2,map[i+size/2][j+size/2]);
        answer += ")";



    }
}
