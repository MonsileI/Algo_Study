package Algorithm_fifteenth_week_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_2224_명제증명_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][]arr = new boolean[60][60];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            char f = str.charAt(0);
            char s = str.charAt(5);
            arr[f-'A'][s-'A'] = true;
        }
        StringBuilder sb = new StringBuilder();
        char[]ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ888888abcdefghijklmnopqrstuvwxyz".toCharArray();
        for(int l=0;l<60;l++){
            for(int i=0;i<60;i++){
                for(int j=0;j<60;j++){
                    if(i==j) continue;
                    if(arr[i][l]&&arr[l][j])arr[i][j] = true;
                }
            }
        }
        int cnt = 0;
        for(int i=0;i<60;i++) {
            for(int j=0;j<60;j++){
                if(i==j) continue;
                if(arr[i][j]) {
                    cnt++;
                    sb.append(ch[i]+" => "+ch[j]+"\n");
                }
            }
        }
        sb.insert(0,cnt+"\n");
        System.out.println(sb.toString());

    }
}
