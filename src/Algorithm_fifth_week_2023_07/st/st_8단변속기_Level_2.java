package Algorithm_fifth_week_2023_07.st;

import java.io.*;
import java.util.*;

public class st_8단변속기_Level_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String answer = "";
        int fir = Integer.parseInt(st.nextToken());
        boolean flag = true;
        if(fir==8){
            answer = "descending";
            flag= false;
        }
        else if(fir==1){
            answer = "ascending";
            flag = true;
        }
        else answer = "mixed";

        if(!answer.equals("mixed")){
            int idx = flag ? 1 : 8;
            for(int i=0;i<7;i++){
                int num = Integer.parseInt(st.nextToken());
                if(flag) {
                    if(num==idx+1) idx++;
                    else {
                        answer="mixed";
                        break;
                    }
                }else{
                    if(num==idx-1) idx--;
                    else {
                        answer="mixed";
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
