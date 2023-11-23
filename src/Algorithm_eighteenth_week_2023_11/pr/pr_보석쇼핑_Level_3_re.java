package Algorithm_eighteenth_week_2023_11.pr;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class pr_보석쇼핑_Level_3_re {

    static int[] solution(String[] gems) {

        Map<String,Integer> checkMap = new HashMap<>();
        int N = gems.length;
        int idx = 0;
        int[]arr = new int[N];
        for(int i=0;i<N;i++){
            if(!checkMap.containsKey(gems[i])) checkMap.put(gems[i],idx++);
            arr[i] = checkMap.get(gems[i]);
        }
        int []answer = new int[2];
        int[]check = new int[idx];
        int L = 0 ; int R = 0;
        for(int i=0;i<N;i++){
            if(check[arr[i]]==0) idx--;
            check[arr[i]]++;
            if(idx==0) {
                R=i;
                break;
            }
        }
        boolean flag = true;
        answer[0] = L+1; answer[1] = R+1;
        int ans = R-L;
        while(R<N){
            if(flag){
                if(R-L<ans){
                    ans = R-L;
                    answer[0] = L+1; answer[1] = R+1;
                }
                if(check[arr[L]]==1) flag= false;
                check[arr[L]]--;
                L++;
            }else{
                R++;
                if(R==N) break;
                if(check[arr[R]]==0) flag = true;
                check[arr[R]]++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[]gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        System.out.println(Arrays.toString(solution(gems)));
    }
}
