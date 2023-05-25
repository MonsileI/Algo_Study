package May_Fourth.pr_;

import java.util.Arrays;
import java.util.Stack;

public class pr_과제진행하기_Level_2 {
    static class Subject implements Comparable<Subject>{
        String name; int start; int range;

        public Subject(String name, int start, int range) {
            this.name = name;
            this.start = start;
            this.range = range;
        }

        @Override
        public int compareTo(Subject o) {
            return start - o.start;
        }
    }
    public static void main(String[] args) {
        String[][]plans = {{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}};
        int size= plans.length;
        String[] answer = new String[size];
        int idx = 0;
        Subject[] subjects = new Subject[size];
        //정렬
        for(int i=0;i<size;i++){
            String[]tmp = plans[i];
            String name = tmp[0];
            String[]t = tmp[1].split(":");
            int startTime = Integer.parseInt(t[0])*60 + Integer.parseInt(t[1]);
            int take = Integer.parseInt(tmp[2]);
            Subject subject = new Subject(name,startTime,take);
            subjects[i] = subject;
        }
        Arrays.sort(subjects);
        Stack<Subject> stack = new Stack<>();

        for(int i=0;i<size;i++){
            if(i==size-1){
                Subject subject = subjects[i]; //마지막일땐 그냥 넣어줌
                answer[idx++] = subject.name;
                break;
            }
            Subject subject = subjects[i]; //현재꺼
            Subject nextSubject = subjects[i+1];//다음꺼
            //만약에 다음꺼보다 endTime이 길 경우, stack에 넣어준다
            int endTime = subject.start+subject.range;
             if(nextSubject.start<endTime){
                 subject.range -= nextSubject.start - subject.start;
                 stack.add(subject);
            }else{
                 //일단 다음꺼보다 작기 때문에 넣어준다.
                 answer[idx++] = subject.name;
                 while(true){
                    if(stack.isEmpty()) break;
                    Subject nextStack = stack.pop();
                    if(nextSubject.start >= endTime + nextStack.range){
                        answer[idx++] = nextStack.name;
                        endTime += nextStack.range;
                    }else{
                        nextStack.range -= nextSubject.start - endTime;
                        stack.push(nextStack);
                        break;
                    }
                 }
             }
        }
        while(!stack.isEmpty()) answer[idx++] = stack.pop().name;
        System.out.println(Arrays.toString(answer));


    }
}
