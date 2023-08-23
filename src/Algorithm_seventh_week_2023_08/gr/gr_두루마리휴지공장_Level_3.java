package Algorithm_seventh_week_2023_08.gr;

import java.util.*;
import java.io.*;
public class gr_두루마리휴지공장_Level_3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[]arr = new int[N];
        st= new StringTokenizer(br.readLine()," ");
        int max = 0; int min =987654321;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max,arr[i]); min = Math.min(min,arr[i]);
        }
        int L = max - min; int R = Integer.MAX_VALUE;
        if(M>=L){
            int answer = 0;
            boolean flag = true;
            while(L<=R){
                flag = true;
                int mid = (L+R)/2;
                int sum = 0;
                for(int i=0;i<N;i++){
                    if(mid<=arr[i]) continue;
                    sum += mid - arr[i];
                    if(M<sum) {
                        flag= false;
                        break;
                    }
                }
                if(sum<=M){
                    answer = mid;
                    L = mid+1;
                }else{
                    R = mid-1;
                }
            }
                if(!flag && answer == Integer.MAX_VALUE) System.out.println("No way!");
                else System.out.println(answer);
        }else{
            System.out.println("No way!");
        }

    }
}
