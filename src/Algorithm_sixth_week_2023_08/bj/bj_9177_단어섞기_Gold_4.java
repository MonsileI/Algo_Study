package Algorithm_sixth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_9177_단어섞기_Gold_4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine())+1;
        StringBuilder sb= new StringBuilder();
        StringTokenizer st = null;
        int fidx =0; int sidx =0; int tgidx = 0;
        for(int t=1;t<TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            char []f = st.nextToken().toCharArray();
            char []s = st.nextToken().toCharArray();
            char []tg = st.nextToken().toCharArray();
            fidx = f.length-1; sidx= s.length-1; tgidx = tg.length-1;
            boolean flag = true;
            while(true){
                if(fidx==-1){
                    char sch = s[sidx];
                    char tch = tg[tgidx];
                    if(sch!=tch) {
                        flag= false;
                        sb.append("Data set "+t+": no\n");
                        break;
                    }else{
                        tgidx--; sidx--;
                    }
                }else if(sidx==-1){
                    char fch = f[fidx];
                    char tch = tg[tgidx];
                    if(fch!=tch) {
                        flag= false;
                        sb.append("Data set "+t+": no\n");
                        break;
                    }else{
                        tgidx--; fidx--;
                        if(tgidx==-1) break;
                    }
                }else{
                    char fch = f[fidx];
                    char sch = s[sidx];
                    char tch = tg[tgidx];
                    if(fch==tch){
                        tgidx--; fidx--;
                    }else if(sch==tch){
                        tgidx--; sidx--;
                    }else{
                        flag= false;
                        sb.append("Data set "+t+": no\n");
                        break;
                    }
                }
                if(tgidx==-1) break;
            }

            if(flag) sb.append("Data set "+t+": yes\n");

        }
        System.out.println(sb.toString());
    }
}
