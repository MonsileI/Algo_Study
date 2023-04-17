package March_Second;

import java.util.*;
import java.io.*;
public class bj_10971_외판원순2_Silver_2 {
    static int N;
    static boolean [] visited;
    static int[][]nums;
    static int answer = 987654321;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st  = null;
        visited = new boolean[N];
        nums = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++) nums[i][j] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<N;i++){
            visited[i] = true;
            check(0,i,i,0);
            visited[i] = false;
        }
        System.out.println(answer);
    }

    static void check(int cnt,int start,int now,int range){

        if(cnt==N-1){
            if(nums[now][start]!=0){
                range += nums[now][start];
                answer = Math.min(answer, range);
            }
            return;
        }

        for(int i=0;i<N;i++){
            if(!visited[i] && nums[now][i]!=0){
                visited[i] = true;
                range += nums[now][i];
                check(cnt+1,start,i,range);
                visited[i] = false;
            }
        }


    }
}
