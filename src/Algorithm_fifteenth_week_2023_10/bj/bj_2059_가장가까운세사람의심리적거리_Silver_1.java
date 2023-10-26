package Algorithm_fifteenth_week_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_2059_가장가까운세사람의심리적거리_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        String mbti = "ESTJ";
        for(int t=0;t<TC;t++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine()," ");
            boolean[][]check = new boolean[N][4];
            for(int i=0;i<N;i++){
                String str = st.nextToken();
                for(int j=0;j<4;j++){
                    if(mbti.charAt(j)==str.charAt(j)) check[i][j] = true;
                    else check[i][j] = false;
                }
            }
            int gugu = N > 32 ? 33 : N;
            int min  = 12; //최대값은 12 4*3
            OuterLoop:
            for(int i=0;i<gugu;i++){
                for(int j=i+1;j<gugu;j++){
                    for(int k=j+1;k<gugu;k++){
                        int cnt = 0;
                        for(int c=0;c<4;c++){
                            if(check[i][c]!=check[j][c]) cnt++;
                            if(check[i][c]!=check[k][c]) cnt++;
                            if(check[j][c]!=check[k][c]) cnt++;
                        }
                        min = Math.min(min,cnt);
                        if(min==0) break OuterLoop;
                    }
                }
            }
            sb.append(min+"\n");
        }
        System.out.println(sb.toString());
    }
}
