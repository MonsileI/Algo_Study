package Algorithm_nineteenth_week_2023_12.복습;
import java.util.*;
import java.io.*;
public class bj_3980_선발명단_Gold_5 {
    static int[][]pos;
    static boolean[]visited;
    static int ans;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        StringTokenizer st = null;
        for(int t=0;t<TC;t++){
            pos = new int[11][11];
            for(int i=0;i<11;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<11;j++){
                    pos[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            ans = 0;
            visited = new boolean[11];
            dfs(0,0); //sum,depth
            sb.append(ans+"\n");
        }
        System.out.println(sb.toString());
    }
    static void dfs(int sum,int depth){
        if(depth==11){
            ans = Math.max(ans,sum);
            return;
        }
        for(int i=0;i<11;i++){
            if(!visited[i]&&pos[depth][i]!=0){
                visited[i] = true;
                dfs(sum+pos[depth][i],depth+1);
                visited[i] = false;
            }
        }
    }


}
