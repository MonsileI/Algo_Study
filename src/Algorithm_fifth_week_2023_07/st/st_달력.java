package Algorithm_fifth_week_2023_07.st;

import java.io.*;
import java.util.*;

public class st_달력 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[]c={31,28,31,30,31,31,30,31,30,31,30,31};
        String[]month = {"january","febraury","march","april","may","june","july","august","september","october","november","december"};
        String[]week = {"first","second","third","fourth","last"};
        String[]day = {"sunday","monday","tuesday","wednesday","thursday","friday","saturday"};
        String firstday = "sunday";
        String[]input = {"first january of sunday","last march of wednesday","second febraury of wednesday","third april of wednesday"};
        StringBuilder sb = new StringBuilder();

        int[][]f_e = new int[12][2];
        int today = 1;
        int f = 0;
        for(int i=0;i<7;i++) if(firstday.equals(day[i])){ f= i; break;}
        for(int i=0;i<12;i++){
            f_e[i][0] = f;
            while (true) {
                today++; f++;
                if(c[i]<=today){
                    f_e[i][1] = f;
                    today=1;
                    f++;
                    break;
                }
                if(6<f) f=0;
            }
        }

        for(int tc=0;tc< input.length;tc++){

            String[]tmp = input[tc].split(" ");
            String w = tmp[0];
            String m = tmp[1]; String d = tmp[3];

            int tm =0; int tw = 0; int td = 0;
            for(int i=0;i<7;i++){
                if(m.equals(month[i])){
                    tm = i;
                    break;
                }
            }
            sb.append(tm+1+" ");
            for(int i=0;i<5;i++){
                if(w.equals(week[i])){
                    tw = i;
                    break;
                }
            }
            int nowDay = 0;
            if(tm==0) nowDay=1;
            nowDay += (tw)*7;
            if(tm!=0) nowDay -= f_e[tm-1][1];
            for(int i=0;i<7;i++){
                if(d.equals(day[i])){
                    td = i;
                    break;
                }
            }

            nowDay += td;
            if(c[tm]<nowDay) nowDay -=7;
            sb.append((nowDay)+"\n");

        }
        System.out.println(sb.toString());
    }
}
