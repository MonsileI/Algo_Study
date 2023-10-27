package Algorithm_fifteenth_week_2023_10.bj;
import java.util.*;
import java.io.*;
public class bj_25644_최대상승_Silver_5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        int[]arr = new int[N];
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        int min = arr[0];
        for(int i=1;i<N;i++){
            answer = Math.max(answer,arr[i] - min);
            min = Math.min(min,arr[i]);
        }
        System.out.println(answer);

    }
}
