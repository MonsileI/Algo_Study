package Algorithm_sixth_week_2023_08.bj;

import java.util.*;
import java.io.*;

public class bj_2195_문자열복사_Gold_5_Stack {
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String p = br.readLine();
        int idx=0;
        int cnt=1;
        for(int i=0;i<p.length();i++){
            if(s.indexOf(p.substring(idx,i+1))!=-1)continue;
            idx = i;
            cnt++;
        }
        System.out.println(cnt);
    }
}
