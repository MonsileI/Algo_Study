package Jun_third.bj;

import java.util.*;
import java.io.*;
public class bj_1182_부분수열의합_Silver_2 {

    static int N,S,answer;
    static int arr[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        answer = 0;
        for(int i=0;i<N;i++){
            int tmp = arr[i];
            for(int j=i;j<N;j++){
                tmp += arr[j];
                if(tmp==S) answer++;
                tmp -= arr[j];
            }
        }

    }
}
