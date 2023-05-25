package May_Fourth.pr_;

import java.util.*;

public class pr_개인정보수유효기간_Level_1 {
    public static void main(String[] args) {
        String today = "2020.01.01"; String [] terms = {"Z 3", "D 5"}; String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
        //오늘 날짜 숫자로 변환(뒤에 두자리만 2000~ 2022년 까지 이기 떄문에)
        int day = change(today);
        Map<Character,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int size = terms.length;
        for(int i=0;i<size;i++){
            String[]tmp = terms[i].split(" ");
            char ch = tmp[0].charAt(0);
            map.put(ch, Integer.parseInt(tmp[1]));
        }
        size = privacies.length;
        for(int i=0;i<size;i++){
             //2021.05.02 A"
            String now = privacies[i];
            String[]tmp = now.split(" ");
            int nowDay = change(tmp[0]);
            int month = map.get(tmp[1].charAt(0));
            if(nowDay + (month*28) <= day) list.add(i+1);
        }
        System.out.println(list);
    }
    static int change(String day){
        int returnNum = 0;
        String[]tmp = day.split("\\.");
        returnNum += Integer.parseInt(tmp[2]); //일수
        returnNum += Integer.parseInt(tmp[1]) * 28;// 달
        returnNum += (Integer.parseInt(tmp[0]) -2000) * 12 * 28;
        return returnNum;
    }
}
