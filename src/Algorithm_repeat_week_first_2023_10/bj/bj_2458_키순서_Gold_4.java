package Algorithm_repeat_week_first_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_2458_키순서_Gold_4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][]map = new boolean[N+1][N+1];
        boolean[][]reverseMap = new boolean[N+1][N+1];
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
                    if(map[i][l]&&map[l][j]) map[i][j] = true;
                    if(reverseMap[i][l]&&reverseMap[l][j]) reverseMap[i][j] = true;
                }
            }
        }
        int ans = 0;
        OuterLoop:
        for(int i=1;i<N+1;i++){

            for(int j=1;j<N+1;j++){
                if(i==j) continue;
                if(!map[i][j] && !reverseMap[i][j]) continue OuterLoop;
            }
            ans++;
        }
        System.out.println(ans);
    }
}
