package Algorithm_fifth_week_2023_07.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2559_수열_Silver_3_sliding {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); int K = Integer.parseInt(st.nextToken());
        int[]arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int answer = 0;
        int tmp = 0;
        for(int i=0;i<K;i++) tmp += arr[i];
        answer = tmp;
        for(int i=0;i<N-K;i++){
            tmp -= arr[i];
            tmp += arr[i+K];
            answer =Math.max(answer,tmp);
        }
        System.out.println(answer);
    }
}
