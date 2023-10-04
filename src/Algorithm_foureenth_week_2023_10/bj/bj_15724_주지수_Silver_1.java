package Algorithm_foureenth_week_2023_10.bj;
import java.util.*;
import java.io.*;
public class bj_15724_주지수_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][]map = new int[N+1][M+1];
        int[][]sumMap = new int[N+1][M+1];
        for(int i=1;i<N+1;i++){
            st= new StringTokenizer(br.readLine()," ");
            for(int j=1;j<M+1;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                sumMap[i][j] = map[i][j];
            }
        }
        for(int j=0;j<M+1;j++){
            int sum = 0;
            for(int i=0;i<N+1;i++){
                sum += sumMap[i][j];
                sumMap[i][j] = sum;

            }
        }
        for(int i=0;i<N+1;i++){
            int sum = 0;
            for(int j=0;j<M+1;j++){
                sum += sumMap[i][j];
                sumMap[i][j] = sum;

            }
        }
        int o = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<o;i++){
            st = new StringTokenizer(br.readLine());
            int fi = Integer.parseInt(st.nextToken())-1;
            int fj = Integer.parseInt(st.nextToken())-1;
            int si = Integer.parseInt(st.nextToken())-1;
            int sj = Integer.parseInt(st.nextToken())-1;
            int ans = sumMap[fi][fj] + sumMap[si+1][sj+1] - sumMap[si+1][fj] - sumMap[fi][sj+1];
            if(i==o-1){
                sb.append(ans);
                break;
            }
            sb.append(ans+"\n");
        }
        System.out.println(sb.toString());

    }
}
