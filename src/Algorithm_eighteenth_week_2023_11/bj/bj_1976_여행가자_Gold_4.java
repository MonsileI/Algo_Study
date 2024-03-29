package Algorithm_eighteenth_week_2023_11.bj;
import java.util.*;
import java.io.*;
public class bj_1976_여행가자_Gold_4 {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[][]map = new boolean[N+1][N+1];
        StringTokenizer st = null;
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<N+1;j++){
                if(i==j){
                    st.nextToken();
                    map[i][j] = true;
                    continue;
                }
                int num = Integer.parseInt(st.nextToken());
                if(num==1){
                    map[i][j] = true;
                }

            }
        }
        for(int l=1;l<N+1;l++){
            for(int i=1;i<N+1;i++){
                for(int j=1;j<N+1;j++){
                    if(i==j) continue;
                    if(map[i][j]) continue;
                    if(map[i][l]&&map[l][j]) map[i][j]=true;
                }
            }
        }
        st= new StringTokenizer(br.readLine()," ");
        int before = Integer.parseInt(st.nextToken());
        boolean flag = true;
        for(int i=1;i<M;i++){
            int num = Integer.parseInt(st.nextToken());
            if(!map[before][num]){
                flag= false;
                break;
            }
            before = num;
        }
        System.out.println(flag ? "YES" : "NO");


    }
}
