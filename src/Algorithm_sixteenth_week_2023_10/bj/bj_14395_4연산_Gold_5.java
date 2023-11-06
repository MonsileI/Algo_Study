package Algorithm_sixteenth_week_2023_10.bj;
import java.util.*;
import java.io.*;

public class bj_14395_4연산_Gold_5 {

    static class Node{
        long num; String h;

        public Node(long num, String h) {
            this.num = num;
            this.h = h;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        long N = Integer.parseInt(st.nextToken());
        long G = Integer.parseInt(st.nextToken());
        String ans = "";
        if(G==N) ans = "0";
        else if(G==1) ans="/";
        else{
            Set<Long> set = new HashSet<>();
            Queue<Node> q = new ArrayDeque<>();
            q.offer(new Node(N,""));
            while(!q.isEmpty()){
                Node now = q.poll();
                long num = now.num;
                if(num==G){
                    ans = now.h;
                    break;
                }
                for(int i=0;i<3;i++){
                    switch (i){
                        case 0: if(num*num<=G && !set.contains(num*num)) {
                            set.add(num*num);
                            q.offer(new Node(num*num,now.h+"*"));
                        }
                            break;
                        case 1:if(num+num<=G && !set.contains(num+num)){
                            set.add(num+num);
                            q.offer(new Node(num+num,now.h+"+"));
                        }
                            break;
                        case 2:if(num-num>-1 && !set.contains(num-num)) {
                            set.add(num-num);
                            q.offer(new Node(num-num,now.h+"-"));
                        }
                        case 3:if(!set.contains(1L)) {
                            set.add(1L);
                            q.offer(new Node(1,now.h+"/"));
                        }
                            break;
                    }
                }
            }
        }
        System.out.println(ans.isEmpty() ? -1 : ans);
    }
}
