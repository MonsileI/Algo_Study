package Algorithm_twenty_week_2023_12.복습;
import java.util.*;
import java.io.*;
public class bj_10816_숫자카드2_Silver_4 {
    static int []arr;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        arr = new int[N];
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb=  new StringBuilder();
        for(int i=0;i<M;i++){
            int num  = Integer.parseInt(st.nextToken());
            sb.append(upper(num)-lower(num)+" ");
        }
        System.out.println(sb.toString());
    }
    //1 2 3 4 5 5 5 6    4   4
    //5
    static int lower(int num){
        int L =0; int R = N;
        while(L<R){
            int mid = (L+R)/2;
            if(arr[mid]<num) L = mid+1;
            else R = mid;
        }
        return L;
    }
    //1 2 3 4 5 5 5 6    7   7
    //5
    static int upper(int num){
        int L =0; int R = N;
        while(L<R){
            int mid = (L+R)/2;
            if(arr[mid]<=num) L = mid+1;
            else R = mid;
        }
        return L;
    }
}
