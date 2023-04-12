package April_Second;


import java.util.*;

public class pr_과제진행하기_Level_2 {

    static class Subject {
        int idx;
        int start;
        int time;

        public Subject(int idx, int start, int time) {
            this.idx = idx;
            this.start = start;
            this.time = time;
        }
    }
    static int change(String start){
        String[]tmp = start.split(":");
        int hour = Integer.parseInt(tmp[0]) * 60;
        return hour + Integer.parseInt(tmp[1]);
    }
    public static void main(String[] args) {
        String [][] plans = {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}};
        Subject[] sche = new Subject[plans.length];
        Stack<Subject> remain = new Stack<>();
        //1. 숫자로 변환, Subject에 넣어주기
        List<String> answer = new ArrayList<>();
        for(int i=0;i<plans.length;i++){
            int idx = i;
            int start = Integer.parseInt(plans[i][1].split(":")[0])*60 + Integer.parseInt(plans[i][1].split(":")[1]);
            int time = Integer.parseInt(plans[i][2]);
            sche[i] = new Subject(idx,start,time);
        }

        for(int i=0;i<plans.length-1;i++){

            int nowTime = sche[i].start + sche[i].time;
            int nextTime = sche[i+1].start;

            if(nowTime<=nextTime){
                answer.add(plans[sche[i].idx][0]);
                int remainTime = nextTime - nowTime;
                while(remainTime > 0 && !remain.isEmpty()) {
                    int del = remain.peek().time - remainTime;
                    if (del < 0) {
                        remainTime = -1 * del;
                        answer.add(plans[remain.pop().idx][0]);
                    } else break;
                }
            }else {
                sche[i].time = (nowTime - nextTime);
                remain.push(sche[i]);

            }

        }


        answer.add(plans[sche[sche.length - 1].idx][0]);
        while(!remain.isEmpty()) answer.add(plans[remain.pop().idx][0]);
        for(String str : answer) System.out.println(str);




    }
}