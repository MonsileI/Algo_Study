package April_Second;


import java.util.*;

public class pr_과제진행하기_Level_2_re {

    static class Node implements Comparable<Node>{

        int idx;
        int start;
        int time;

        @Override
        public int compareTo(Node o) {
            return start - o.start;
        }

        public Node(int idx, int start, int time) {
            this.idx = idx;
            this.start = start;
            this.time = time;
        }
    }
    public static void main(String[] args) {

        String [][] plans = {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}};
        Node[] myPlans = new Node[plans.length];

        for(int i=0;i<plans.length;i++){
            int start = Integer.parseInt(plans[i][1].split(":")[0]) * 60 + Integer.parseInt(plans[i][1].split(":")[1]);
            int time = Integer.parseInt(plans[i][2]);
            myPlans[i] = new Node(i,start,time);
        }
        List<String> answer = new ArrayList<>();
        Stack<Node>remain = new Stack<>();

        for(int i=0;i<plans.length-1;i++){
            int cur = myPlans[i].start + myPlans[i].time;
            int next = myPlans[i+1].start;

            if(cur <= next){
                answer.add(plans[myPlans[i].idx][0]);

                int jjaturi = next - cur;
                while(jjaturi > 0 && !remain.isEmpty()){
                    int del = remain.peek().time - jjaturi;
                    remain.peek().time = Math.max(0, del);
                    if(del == 0) {
                        jjaturi = -1 * del;
                        answer.add(plans[remain.pop().idx][0]);
                    }else break;
                }
            }else{
                myPlans[i].time = (cur - next);
                remain.push(myPlans[i]);
            }
        }
        answer.add(plans[myPlans[myPlans.length - 1].idx][0]);
        while(!remain.isEmpty()) answer.add(plans[remain.pop().idx][0]);
        for(String str : answer) System.out.println(str);
    }

}

