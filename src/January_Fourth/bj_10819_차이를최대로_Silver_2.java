package January_Fourth;

import java.util.*;
import java.io.*;
public class bj_10819_차이를최대로_Silver_2 {
    static int answer,N,arr[],tmp[];
    static boolean[]visited;

    static void calc(){
        int sum = 0;
        for(int i=0;i<N-1;i++) sum += Math.abs(arr[tmp[i]]-arr[tmp[i+1]]);
        answer = Math.max(answer,sum);
    }
    static void dfs(int depth){
        if(N==depth){
            calc();
            return;
        }
        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                tmp[depth] = i;
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        tmp = new int[N];
        visited = new boolean[N];
        answer = 0;
        dfs(0);
        System.out.println(answer);
    }
}
