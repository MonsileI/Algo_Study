package April_Second;


import java.util.*;

public class pr_과제진행하기_Level_2 {

    static class Sub {
        String sub;
        int total;

        @Override
        public String toString() {
            return "Sub{" +
                    "sub='" + sub + '\'' +
                    ", total=" + total +
                    '}';
        }

        public Sub(String sub, int total) {
            this.sub = sub;
            this.total = total;
        }
    }
    static int change(String start){
        String[]tmp = start.split(":");
        int hour = Integer.parseInt(tmp[0]) * 60;
        return hour + Integer.parseInt(tmp[1]);
    }
    public static void main(String[] args) {
        String [][] plans = {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}};
        TreeMap<Integer,Sub> map = new TreeMap<>();

        for(int i =0; i <plans.length;i++){
            String key = plans[i][0];
            String start = plans[i][1];
            int s = change(start);
            int time = Integer.parseInt(plans[i][2]);
            map.put(s, new Sub(key,time));
        }




    }
}