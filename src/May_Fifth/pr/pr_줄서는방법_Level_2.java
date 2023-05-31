package May_Fifth.pr;

import java.util.Arrays;

public class pr_줄서는방법_Level_2 {
    static int N,K;
    static int arr[], tmp[];
    static boolean flag;
    static int[]answer;
    static boolean[]visited;
    public static void main(String[] args)  {
        int n = 3;
        int k = 5;
        N = n;
        K=k;
        flag = false;
        arr = new int[N]; tmp = new int[N]; answer = new int[N];
        visited = new boolean[N];
        dfs(0);
        System.out.println(Arrays.toString(answer));
    }
    static void dfs(int depth){

        if(flag) return;

        if(depth==N){
            K--;
            if(K==0){
                flag = true;
                for(int i=0;i<N;i++) answer[i] = tmp[i];
            }
            return;
        }

        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                tmp[depth] = i+1;
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}
