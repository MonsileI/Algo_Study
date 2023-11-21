package Algorithm_fifteenth_week_2023_10.pr;

public class pr_입국심사_Level_3 {
    static long answer = Long.MAX_VALUE;
    static int[]T;
    static int len;
    public static void main(String[] args) {
        int n = 6;
        int [] times = {5,7};
        T = times;
        len = times.length;
        long L = 1; long R = 0;
        for(int i=0;i<len;i++) R = Math.max(R,times[i]);
        R *= n;
        long answer = 0;
        while(L<R){
            long mid = (L+R)/2;
            if(n<=check(mid))R = mid;
            else L = mid+1;
        }
        System.out.println(L);

    }
    static long check(long mid){
        long ans = 0;
        for(int i=0;i<len;i++){
            ans += mid/T[i];
        }
        return ans;
    }
}
