package Algorithm_nineteenth_week_2023_11.bj;
import java.util.*;
import java.io.*;
public class bj_11723_집합_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb  =new StringBuilder();
        int flag = 0;
        for(int t=0;t<TC;t++){
            String[]tmp = br.readLine().split(" ");
            String act = tmp[0];
            if(act.equals("all")){
                flag = 2097150;
                continue;
            }else if(act.equals("empty")){
                flag = 0;
                continue;
            }else{
                int num = Integer.parseInt(tmp[1]);
                if(act.equals("add")){
                    flag = (1 << num) | flag;
                }else if(act.equals("remove")) {
                    flag = ~(1 << num) & flag;
                }else if(act.equals("check")){
                    if((flag & (1 << num)) == 0) sb.append(0);
                    else sb.append(1);
                    sb.append("\n");
                }else if(act.equals("toggle")){
                    flag = ((1<<num) ^ flag);
                }
            }
        }
        System.out.println(sb.toString());
    }
}
