package Algorithm_eighteenth_week_2023_11.pr;

import java.util.*;

public class pr_보석쇼핑_Level_3 {

    static int[] solution(String[] gems) {

        Map<String,Integer> checkMap = new HashMap<>();
        int N = gems.length;
        int idx = 0;
        int[]arr = new int[N];
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<N;i++){
            if(!checkMap.containsKey(gems[i])){
                checkMap.put(gems[i],idx);
                map.put(idx++,0);
            }
            arr[i] = checkMap.get(gems[i]);
        }
        System.out.println(Arrays.toString(arr));
        int L = 0; int R = 0;
        for(int i=0;i<N;i++){
            if(map.get(arr[i])==0){
                idx--;
                map.put(arr[i],1);
            }else map.put(arr[i],map.get(arr[i])+1);
            if(idx==0){
                R = i;
                break;
            }
        }
        boolean flag = true;
        int[]answer = {L+1,R+1};
        int ans = R-L;
        while(R<N){
            if(flag){
                if(R-L<ans){
                    ans = R-L;
                    answer[0] = L+1; answer[1] = R+1;
                }
                if(map.get(arr[L])==1){
                    map.put(arr[L],0);
                    flag = false;
                }else{
                    map.put(arr[L],map.get(arr[L])-1);
                }
                L++;
            }else{
                R++;
                if(R==N) break;
                if(map.get(arr[R])==0){
                    map.put(arr[R],1);
                    flag = true;
                }else map.put(arr[R],map.get(arr[R])+1);

            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[]gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        System.out.println(Arrays.toString(solution(gems)));
    }
}
