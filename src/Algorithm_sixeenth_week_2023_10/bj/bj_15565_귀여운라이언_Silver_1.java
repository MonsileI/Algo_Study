package Algorithm_sixeenth_week_2023_10.bj;
import java.util.*;
import java.io.*;
public class bj_15565_귀여운라이언_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[]arr =new int[N];
        st = new StringTokenizer(br.readLine()," ");
        int L = 0; int R = 0;
        int cnt = 0;
        boolean flag = true;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i]==1&&flag) cnt++;
            if(cnt==K&&flag) {
                R = i;
                flag= false;
            }
        }
        int ans  = R - L + 1;
        if(ans==0 || flag) ans = -1;
        else{
            //투포인터
            while(true){
                if(cnt>=K){
                    ans = Math.min(ans,R-L + 1 );
                    if(arr[L]==1) cnt--;
                    L++;
                    if(L==N) break;
                }else{
                    R++;
                    if(R==N) break;
                    if(arr[R]==1) cnt++;
                }
            }
        }
        System.out.println(ans);
    }
}
