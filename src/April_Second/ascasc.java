package April_Second;

import java.util.*;

public class ascasc {

    static class Node {

        int idx, time, start;
        public Node(int idx, int time, int start) {
            this.idx = idx;
            this.time = time;
            this.start = start;
        }
    }
    public static void main(String[] args) {

        String[][]plans = {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}};
        List<String> answer = new ArrayList<>();
        Node[]schedule = new Node[plans.length];
        Stack<Node> remainSubject = new Stack<>();
        for(int i=0;i<plans.length;i++){
            int startTime = Integer.parseInt(plans[i][1].split(":")[0]) * 60 + Integer.parseInt(plans[i][1].split(":")[1]);
            int takeTime = Integer.parseInt(plans[i][2]);
            Node tmp = new Node(i,takeTime,startTime);
            schedule[i] = tmp;
        }
        for(int i=1;i<plans.length-1;i++){

            int nowTime = schedule[i].start + schedule[i].time;
            int nextTime = schedule[i+1].start;
            int remainTime = nextTime - nowTime;
            if(nowTime < nextTime){
                int del = remainSubject.peek().time - remainTime;
                remainSubject.peek().time = Math.max(0, del);
                if(del == 0) {
                    remainTime = -1 * del;
                    answer.add(plans[remainSubject.pop().idx][0]);
                }else break;
            }
            else{
                schedule[i].time = nowTime - nextTime;
                remainSubject.push(schedule[i]);
            }


        }


    }
}
