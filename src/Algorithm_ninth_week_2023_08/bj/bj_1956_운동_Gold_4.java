package Algorithm_ninth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_1956_운동_Gold_4 {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][]arr = new int[N+1][N+1];
        int INF =987654321;
        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                if(i==j) continue;
                arr[i][j] = 987654321;
            }
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a =Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());
            int c =Integer.parseInt(st.nextToken());
            arr[a][b] = c;
        }

        for(int l=1;l<N+1;l++){
            for(int i =1;i<N+1;i++){
                for(int j=1;j<N+1;j++){
                    if(i==j) continue;
                    if(arr[i][j] > arr[i][l]+arr[l][j]){
                        arr[i][j] = arr[i][l] + arr[l][j];
                    }
                }
            }
        }
        int answer=INF;
        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                if(i==j) continue;
                if(arr[i][j]!=INF && arr[j][i]!=INF){
                    answer = Math.min(answer,arr[i][j]+arr[j][i]);
                }
            }
        }
        answer = (answer==INF) ? -1 : answer;
        System.out.println(answer);

    }
}
