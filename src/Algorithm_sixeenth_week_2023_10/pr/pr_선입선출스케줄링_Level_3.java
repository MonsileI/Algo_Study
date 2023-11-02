package Algorithm_sixeenth_week_2023_10.pr;

import java.util.*;

public class pr_선입선출스케줄링_Level_3 {
    static int[]C;
    static int N;
    public static void main(String[] args) {
        int n = 6;
        int[]cores = {1,2,3};

        C = cores;
        N = cores.length;

        int L =0;
        int R = 10000 * n;
        int time = 0;
        int work = 0;
        while(L<=R){
            int mid = (L+R)/2;
            int count = cal(mid);
            if(count<n) L = mid+1;
            else {
                R = mid-1;
                time = mid;
                work = count;
            }
        }

        work -= n;
        int answer = 0;
        for(int i = cores.length-1; -1<i; i--){
            if (time % cores[i] == 0) {
                if (work == 0) {
                    answer = i+1;
                    break;
                }
                work--;
            }
        }
        System.out.println(answer);
    }
    static int cal(int mid){
        if(mid==0) return N;
        int cnt = N;
        for(int i=0;i<N;i++){
            cnt += mid/C[i];
        }
        return cnt;
    }
}
