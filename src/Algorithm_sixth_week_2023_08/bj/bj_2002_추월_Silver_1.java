package Algorithm_sixth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_2002_추월_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String,Integer> map = new HashMap<>();
        int[]arr = new int[N];
        for(int i=0;i<N;i++) {
            String str = br.readLine();
            map.put(str,i);
        }
        for(int i=0;i<N;i++){
            arr[i] = map.get(br.readLine());
        }
        int answer = 0;

        for(int i=0;i<N-1;i++) {
            for(int j=i+1;j<N;j++){
                if(arr[i]>arr[j]){
                    answer++;
                    break;
                }
            }
        }

        System.out.println(answer);

    }
}
