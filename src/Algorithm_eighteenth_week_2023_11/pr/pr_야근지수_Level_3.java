package Algorithm_eighteenth_week_2023_11.pr;
import java.util.*;
public class pr_야근지수_Level_3 {
    public static void main(String[] args) {
        int [] works = {1,1};
        int n = 3;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->o2.compareTo(o1));
        for(int i=0;i<works.length;i++)pq.offer(works[i]);
        while(0<n){
            int tmp = pq.poll();
            if(tmp-1<0) pq.offer(0);
            else pq.offer(tmp-1);
            n--;
        }
        System.out.println(pq);
        long ans = 0;
        while(!pq.isEmpty()){
            int num = pq.poll();
            ans += Math.pow(num,2);
        }
        System.out.println(ans);
    }
}
