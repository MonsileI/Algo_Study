package Algorithm_seventeenth_week_2023_11.bj;
import java.util.*;
import java.io.*;
public class bj_17088_등차수열_Gold_5 {
    static int N;
    static int[]arr;
    static int ans = 987654321;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        //9가지 경우의 수를 돌려준다.
        if(N==1) ans = 0;
        else{
            //차이
            dfs((arr[0]-1)-(arr[1]-1),arr[1]-1,2,2);
            dfs((arr[0])-(arr[1]-1),arr[1]-1,2,1);
            dfs((arr[0]+1)-(arr[1]-1),arr[1]-1,2,2);
            dfs((arr[0]-1)-(arr[1]),arr[1],2,1);
            dfs((arr[0])-(arr[1]),arr[1],2,0);
            dfs((arr[0]+1)-(arr[1]),arr[1],2,1);
            dfs((arr[0]-1)-(arr[1]+1),arr[1]+1,2,2);
            dfs((arr[0])-(arr[1]+1),arr[1]+1,2,1);
            dfs((arr[0]+1)-(arr[1]+1),arr[1]+1,2,2);

        }
        System.out.println(ans==987654321 ? -1 : ans);
    }
    static void dfs(int diff,int before,int nextIdx,int cnt){
        if(N==nextIdx){
            ans = Math.min(ans,cnt);
            return;
        }
        //0과 1의 차이가 diff로 들어옴
        if(before-arr[nextIdx]==diff) dfs(diff,arr[nextIdx],nextIdx+1,cnt);
        if(before-(arr[nextIdx]+1)==diff) dfs(diff,arr[nextIdx]+1,nextIdx+1,cnt+1);
        if(before-(arr[nextIdx]-1)==diff) dfs(diff,arr[nextIdx]-1,nextIdx+1,cnt+1);
    }
}
