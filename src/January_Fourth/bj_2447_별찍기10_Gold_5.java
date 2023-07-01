package January_Fourth;

import java.util.*;
import java.io.*;
public class bj_2447_별찍기10_Gold_5 {
    static int N;
    static char[][]arr;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new char[N][N];
        dfs(0,0,N);
    }
    static void dfs(int i,int j,int size){
        if(size==1) return;
        for(int x=i;i<size+x;x++){
            for(int y=j;y<size+y;y++){
                arr[i][j] = '*';
            }
        }
    }
}
