package Algorithm_seventh_week_2023_08.gr;

import java.io.*;
import java.util.*;

public class gr_구름숫자_Level_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String,Integer> map = new HashMap<>();
        String[]tmp = {"ze","qw","as","zx","we","sd","xc","er","df","cv"};
        for(int i=0;i<10;i++) map.put(tmp[i],i);
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int size = str.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<size-1;i++){
            String num = ""+str.charAt(i)+str.charAt(i+1);
            if(map.containsKey(num)) sb.append(map.get(num));
        }
        System.out.println(sb.toString());
    }
}
