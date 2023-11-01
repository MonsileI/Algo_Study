package Algorithm_sixeenth_week_2023_10.bj;
import java.util.*;
import java.io.*;
public class bj_16943_숫자재배치_Silver_1 {
    static String a;
    static String b;
    static int N;
    static int ans;
    static boolean[]visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        a  = st.nextToken();
        b = st.nextToken();
        if(a.length()>b.length()) System.out.println(-1);
        else{
            N = a.length();
            visited = new boolean[N];
            dfs(0,"");
            System.out.println(ans==0 ? -1 : ans);
        }
    }
    static void dfs(int depth,String sum){

        if(depth==N){
            int num = Integer.parseInt(sum);
            if(num<Integer.parseInt(b)) ans = Math.max(ans,num);
            return;
        }
        for(int i=0;i<N;i++){
            if(depth==0&&a.charAt(i)=='0') continue;
            if(!visited[i]){
                visited[i] = true;
                dfs(depth+1,sum+a.charAt(i));
                visited[i] = false;
            }
        }

    }
}
