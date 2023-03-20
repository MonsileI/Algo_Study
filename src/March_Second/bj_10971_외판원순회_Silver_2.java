package March_Second;

import java.util.*;
import java.io.*;
public class bj_10971_외판원순회_Silver_2    {
    static int N;
    static int[][]nums;
    static boolean[]visited;
    static int answer;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N+1][N+1];
        visited = new boolean[N+1];
        StringTokenizer st =  null;
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<N+1;j++){
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = 987654321;

        for(int i=1;i<N+1;i++){
            visited[i] = true;
            dfs(i,i,1,0);
            visited[i] = false;

        }

        System.out.println(answer);
    }

    static void dfs(int start,int now,int cnt,int sum){

        if(cnt==N){
            if(nums[now][start]!=0){
                sum += nums[now][start];
                answer = Math.min(answer,sum);
            }
            return;
        }

        for(int i=1;i<N+1;i++){
            if(!visited[i]&&nums[now][i]!=0){
                visited[i] = true;
                sum += nums[now][i];
                dfs(start,i,cnt+1,sum);
                visited[i] = false;
            }
        }

    }
}
