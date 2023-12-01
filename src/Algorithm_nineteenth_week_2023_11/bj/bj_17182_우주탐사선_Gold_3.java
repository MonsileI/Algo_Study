package Algorithm_nineteenth_week_2023_11.bj;
import java.util.*;
import java.io.*;
public class bj_17182_우주탐사선_Gold_3 {
    static int N;
    static int map[][];
    static boolean[]visited;
    static int answer = 987654321;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int l=0;l<N;l++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(i==j) continue;
                    map[i][j] = Math.min(map[i][j],map[i][l]+map[l][j]);
                }
            }
        }

        visited=  new boolean[N];
        visited[S] = true;
        dfs(S,1,0);
        System.out.println(answer);
    }
    static void dfs(int node, int depth,int sum){
        if(depth==N){
            answer = Math.min(answer,sum);
            return;
        }
        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i,depth+1,sum+map[node][i]);
                visited[i] = false;
            }
        }
    }

}
