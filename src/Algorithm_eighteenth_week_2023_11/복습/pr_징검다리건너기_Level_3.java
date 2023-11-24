package Algorithm_eighteenth_week_2023_11.복습;
import java.util.*;
public class pr_징검다리건너기_Level_3 {
    static int solution(int[] stones, int k){
        int L  = 0 ; int R  = 200000000;
        int N = stones.length;
        while(L<R){
            int mid = (L+R)/2;
            int tmp = 0;
            boolean flag = true;
            for(int i=0;i<N;i++){
                if(stones[i]<mid) tmp++;
                else tmp = 0;
                if(k==tmp){
                    flag = false;
                    break;
                }
            }
            if(flag) L = mid +1;
            else R = mid;
        }
        return L-1;
    }

    public static void main(String[] args) {
        int[]stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        System.out.println(solution(stones,k));
    }

}
