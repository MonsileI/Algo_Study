package Algorithm_nineteenth_week_2023_11.calender;

import java.io.*;

public class calendar {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String start = br.readLine();
        String end = br.readLine();
        StringBuilder sb=  new StringBuilder();
        String tmp = start.substring(0,2);
        tmp += "11";
        tmp += start.substring(4,6);
        start = tmp;
        int a = Integer.parseInt(start);
        int b = Integer.parseInt(end);
        for(int i=a;i<=b;i+=10000){
            for(int j=i;j<=i+29;j++){
                String num = String.valueOf(j);
                if(check(num)) sb.append(num+"\n");
            }
        }
        System.out.println("==================");
        System.out.println(sb.toString());
    }
    static boolean check(String num){
        int L = 0 ; int R = num.length()-1;
        while(L<=R){
            char f = num.charAt(L);
            char s = num.charAt(R);
            if(f!=s) return false;
            L++; R--;
        }
        return true;
    }
}
