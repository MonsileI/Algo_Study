package April_Second;

import java.util.*;
import java.io.*;
public class bj_1806_부분합_Gold_4 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[]arr = new int[N];
        st = new StringTokenizer(br.readLine()," ");

        for(int i=0;i<N;i++) arr[i] =  Integer.parseInt(st.nextToken());

        int answer = 987654321;
        int L = 0;
        int R = 0;
        int sum = 0;
        while(true){

            if(S<=sum){
                answer = Math.min(answer, R-L);
                sum -= arr[L];
                L++;
            }else{
                if(R==N) break;
                else {
                    sum += arr[R];
                    R++;
                }
            }

        }
        System.out.println(answer ==987654321 ? 0 : answer);
    }

}
