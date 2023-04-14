package April_Second;

import java.util.*;
import java.io.*;
public class bj_5430_AC_Gold_5 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        OuterLoop:
        for(int t=0;t<TC;t++){


            String command = br.readLine();
            int num = Integer.parseInt(br.readLine());
            String str = br.readLine();
            str = str.replaceAll("\\[","").replaceAll("\\]","").replaceAll(",","");;

            Deque<Integer> deque = new LinkedList<>();

            for(int i=0;i<num;i++) deque.offer(Integer.parseInt(str.charAt(i)+""));


            for(int i=0;i<command.length();i++){

                char ch = command.charAt(i);

                if(ch=='R'){
                    int size = deque.size();
                    for(int j=0;j<size;j++) {
                        int tmp = deque.peekLast();
                        deque.addFirst(tmp);
                        deque.removeFirst();
                        System.out.println(tmp);
                        System.out.println(deque);
                    }
                }else{
                    if(deque.isEmpty()) {sb.append("error").append("\n"); continue OuterLoop; }
                    deque.pop();
                }
            }
            sb.append(deque).append("\n");
        }
        System.out.println(sb.toString());
    }
}
