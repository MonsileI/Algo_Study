package Algorithm_nineteenth_week_2023_11.pr;

import java.util.*;

public class pr_주차요금계산_Level_2 {


    static int[] solution(int[] fees, String[] records) {
        //출차 내용이 없으면 23:59분에 나갔다고 가정한다.
        //
        TreeMap<String,Integer> ansMap = new TreeMap<>();
        Map<String,Integer> map =new HashMap<>();
        for(int i=0;i< records.length;i++){
            String[]tmp  =records[i].split(" ");
            int time = change(tmp[0]);
            String num = tmp[1];
            String act = tmp[2];
            if(act.equals("IN")) map.put(num,time);
            else {
                ansMap.put(num,ansMap.getOrDefault(num,0)+(time-map.get(num)));
                map.put(num,-1);
            }
        }

        int finalTime = change("23:59");
        for(String key : map.keySet()){
            if(map.get(key)!=-1){
                ansMap.put(key,ansMap.getOrDefault(key,0)+finalTime - map.get(key));
            }
        }
        int[]answer = new int[ansMap.size()];
        int idx = 0;
        for(String key : ansMap.keySet()){
            if(ansMap.get(key)<=fees[0]) answer[idx++] = fees[1];
            else{
                int lastTime = ansMap.get(key) - fees[0];
                int fee = ((lastTime/fees[2])*fees[3]) + fees[1];
                if(lastTime%fees[2]!=0) fee += fees[3];
                answer[idx++] = fee;
            }
        }
        return answer;

    }
    static int change(String num){
        String[]tmp = num.split(":");
        int time = Integer.parseInt(tmp[1]) + (Integer.parseInt(tmp[0])*60);
        return time;
    }


    public static void main(String[] args) {
        int[]fees = {1, 461, 1, 10}; //기본시간을 넘어가면, 추가요금을 받는다.. 양아치들
        String[]records = {"00:00 1234 IN"};
        System.out.println(Arrays.toString(solution(fees,records)));
    }
}
