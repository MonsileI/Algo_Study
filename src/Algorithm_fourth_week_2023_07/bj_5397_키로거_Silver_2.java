package Algorithm_fourth_week_2023_07;

import java.io.*;
public class bj_5397_키로거_Silver_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<TC;t++){
            String str = br.readLine();
            int size = str.length();
            String answer = "";
            int idx = 0;
            for(int i=0;i<size;i++){
                char ch = str.charAt(i);
                if(ch=='<') {
                    if (idx != 0) {
                        idx--;
                    }
                }else if(ch=='>') {
                    if (idx < answer.length()) {
                        idx++;
                    }
                }else if(ch=='-') {
                    answer = answer.substring(0,idx-1) + answer.substring(idx,answer.length());
                    if (idx != 0) {
                        idx--;
                    }
                }else{
                    answer = answer.substring(0,idx) + ch + answer.substring(idx,answer.length());
                    idx++;
                }
            }
            sb.append(answer).append("\n");
            }
        System.out.println(sb.toString());
        }

}
