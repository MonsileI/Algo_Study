package Algorithm_third_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_2607_비슷한단어_Silver_3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        String str = br.readLine();
        int strSize = str.length();
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<strSize;i++) map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
        for(int i=1;i<N;i++){
            String check = br.readLine();
            int checkSize = check.length();
            int cnt = 0;
            boolean flag = true;
            Map<Character,Integer> tmp = new HashMap<>();
            for(int j=0;j<checkSize;j++) tmp.put(check.charAt(j),tmp.getOrDefault(check.charAt(j),0)+1);
            System.out.println(map);
            System.out.println(tmp);
            for(Character ch : tmp.keySet()){
                if(map.containsKey(ch)) cnt += Math.abs(map.get(ch) - tmp.get(ch));
                else cnt += tmp.get(ch);
                if(1<cnt) {flag = false; break;}
            }
            if(flag) answer++;
        }
        System.out.println(answer);

    }
}

