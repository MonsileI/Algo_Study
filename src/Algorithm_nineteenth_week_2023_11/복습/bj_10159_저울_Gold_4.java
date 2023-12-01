package Algorithm_nineteenth_week_2023_11.복습;
import java.util.*;
import java.io.*;
public class bj_10159_저울_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[][]map = new boolean[N+1][N+1];
        boolean[][]reverseMap = new boolean[N+1][N+1];
        StringTokenizer st =null;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            map[a][b] = reverseMap[b][a] = true;
        }
        for(int l=1;l<N+1;l++){
            for(int i=1;i<N+1;i++){
                for(int j=1;j<N+1;j++){
                    if(i==j) continue;
                    if(!map[i][j]) if(map[i][l]&&map[l][j]) map[i][j] = true;
                    if(!reverseMap[j][i]) if(reverseMap[j][l] && reverseMap[l][i]) reverseMap[j][i] = true;
                }
            }
        }
        StringBuilder sb=  new StringBuilder();
        for(int i=1;i<N+1;i++){
            int num = 0;
            for(int j=1;j<N+1;j++){
                if(i==j) continue;
                if(!map[i][j]&&!reverseMap[i][j]) num++;
            }
            sb.append(num+"\n");
        }
        System.out.println(sb.toString());
    }
}
