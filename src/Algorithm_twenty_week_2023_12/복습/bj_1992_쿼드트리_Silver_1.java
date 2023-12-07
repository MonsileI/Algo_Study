package Algorithm_twenty_week_2023_12.복습;
import java.util.*;
import java.io.*;
public class bj_1992_쿼드트리_Silver_1 {

    static int N;
    static StringBuilder sb = new StringBuilder();
    static char[][]map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map  = new char[N][N];
        for(int i=0;i<N;i++)map[i] = br.readLine().toCharArray();
        sub(0,0,N,map[0][0]);
        System.out.println(sb.toString());
    }

    static void sub(int y,int x,int size,char value){

        boolean flag = true;
        Loop:
        for(int i=y;i<y+size;i++){
            for(int j=x;j<x+size;j++){
                if(map[i][j]!=value){
                    flag= false;
                    break Loop;
                }
            }
        }
        if(flag) {
            sb.append(value);
            return;
        }
        sb.append("(");
        sub(y,x,size/2,map[y][x]);
        sub(y,x+size/2,size/2,map[y][x+size/2]);
        sub(y+size/2,x,size/2,map[y+size/2][x]);
        sub(y+size/2,x+size/2,size/2,map[y+size/2][x+size/2]);
        sb.append(")");

    }
}
