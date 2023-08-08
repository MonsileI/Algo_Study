package Algorithm_sixth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_14888_연산자끼워넣기_Silver_1 {
    static int N;
    static int[]arr;
    static int[]op;
    static boolean[]visited;

    static int min,max;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        min = 1987654321;
        max = -1987654321;
        N = Integer.parseInt(br.readLine());
        arr= new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        int []tmp = new int[4];
        for(int i=0;i<4;i++){
            int num = Integer.parseInt(st.nextToken());
            tmp[i] = num;
        }
        int idx = 0;
        op = new int[N-1];
        for(int i=0;i<4;i++){
            int num = tmp[i];
            while(true){
                if(num==0) break;
                op[idx++] = i;
                num--;
            }
        }
        visited = new boolean[N-1];
        dfs(0,arr[0]);
        System.out.println(max);
        System.out.println(min);

    }
    static void dfs(int depth, int sum){

        if(depth==N-1){
            min = Math.min(min,sum); max = Math.max(max,sum);
            return;
        }
        for(int i=0;i<N-1;i++){
            if(!visited[i]){
                visited[i] = true;
                int newOne = sum;
                switch(op[i]){
                    case 0 : newOne += arr[depth+1];
                        break;
                    case 1 : newOne -= arr[depth+1];
                        break;
                    case 2 : newOne *= arr[depth+1];
                        break;
                    case 3 : newOne /= arr[depth+1];
                        break;
                }
                dfs(depth+1,newOne);
                visited[i] = false;
            }
        }
    }
}
