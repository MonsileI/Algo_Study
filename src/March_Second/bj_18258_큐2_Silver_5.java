package March_Second;

import java.util.*;
import java.io.*;
public class bj_18258_큐2_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> dq = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            String input = br.readLine();
            String[]tmp = input.split(" ");
            String act = tmp[0];

            if(act.equals("push")){
                int num = Integer.parseInt(tmp[1]);
                dq.offer(num);
            }else {

                switch (act) {
                    case "pop":
                        if (dq.isEmpty()) sb.append(-1).append("\n");
                        else sb.append(dq.pop()).append("\n");
                        break;
                    case "size":
                        sb.append(dq.size()).append("\n");
                        break;
                    case "empty":
                        if (dq.isEmpty()) sb.append(1).append("\n");
                        else sb.append(0).append("\n");
                        break;
                    case "front":
                        if (dq.isEmpty()) sb.append(-1).append("\n");
                        else sb.append(dq.peek()).append("\n");
                        break;
                    case "back":
                        if (dq.isEmpty()) sb.append(-1).append("\n");
                        else sb.append(dq.peekLast()).append("\n");
                        break;
                }
            }
        }

        System.out.println(sb.toString());
    }
}
