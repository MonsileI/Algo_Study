package Algorithm_seventh_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_28447_마라탕재료고르기_Silver_2 {
    static int N;
    static int[][]map;
    static int[]tmp;
    static int C;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        tmp = new int[C];
        comb(0,0);
        System.out.println(answer);

    }
    static void comb(int depth,int start){

        if(depth==C){
            System.out.println(Arrays.toString(tmp));
            int sum = 0;
            for(int i=0;i<C;i++){
                for(int j=i+1;j<C;j++){
                    sum += map[tmp[i]][tmp[j]];
                }
            }
            answer = Math.max(answer,sum);
            return;
        }


        for(int i=start;i<N;i++){
           tmp[depth] = i;
           comb(depth+1,i+1);
        }


    }
}
