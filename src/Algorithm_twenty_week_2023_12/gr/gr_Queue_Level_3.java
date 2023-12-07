package Algorithm_twenty_week_2023_12.gr;
import java.util.*;
import java.io.*;
public class gr_Queue_Level_3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q= new ArrayDeque<>();
        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine()," ");
            String act = st.nextToken();
            if(act.equals("push")){
                int num =  Integer.parseInt(st.nextToken());
                if(q.size()==S) sb.append("Overflow\n");
                else q.offer(num);
            }else{
                if(q.isEmpty()) sb.append("Underflow\n");
                else sb.append(q.poll()+"\n");
            }
        }
        System.out.println(sb.toString());
    }
}
