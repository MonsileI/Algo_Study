package April_Second;


import java.util.*;
import java.io.*;
public class bj_2467_용액_Gold_5 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[]arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());

        int start = 0;
        int end = N-1;
        int min = Integer.MAX_VALUE;
        int[]answer = new int[2];

        while(start<end) {

            int value = arr[start] + arr[end];
            value = Math.abs(value);

            if (value < min) {
                answer[0] = start;
                answer[1] = end;
                min = value;
            }

            if(value> 0) end--;
            else start++;
        }

        System.out.println(arr[answer[0]]+" "+arr[answer[1]]);

    }
}
