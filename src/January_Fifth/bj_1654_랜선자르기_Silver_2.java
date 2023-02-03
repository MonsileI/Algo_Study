package January_Fifth;
import java.util.*;
import java.io.*;

public class bj_1654_랜선자르기_Silver_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int []arr =new int[N];

        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(br.readLine());
        //모자라면 늘려주고,
        Arrays.sort(arr);
        long start=0; long end=arr[N-1];
        while(start<=end){

            long mid = (start+end) / 2;
            long total = 0;

            for(int i=0;i<N;i++) if(mid<=arr[i] && arr[i]!=0 && mid!=0) total += arr[i]/mid;
            if(total<M){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        System.out.println(end);

    }
}
