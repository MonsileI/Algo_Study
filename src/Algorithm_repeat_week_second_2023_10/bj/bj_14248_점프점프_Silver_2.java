package Algorithm_repeat_week_second_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_14248_점프점프_Silver_2 {
    static int N;
    static boolean[]visited;
    static int[]arr;
    static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        int now = Integer.parseInt(br.readLine())-1;
        dfs(now);
        System.out.println(ans);
    }
    static void dfs(int num){
        if(!visited[num]){
            visited[num]= true;
            ans++;
        }else return;
        int f = num - arr[num];
        int s = num + arr[num];
        if(-1<f) dfs(f);
        if(s<N) dfs(s);
    }
}
