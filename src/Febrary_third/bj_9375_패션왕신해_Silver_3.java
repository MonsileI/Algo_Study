package Febrary_third;

import java.util.*;
import java.io.*;
public class bj_9375_패션왕신해_Silver_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<TC;t++){

            int N = Integer.parseInt(br.readLine());
            Map<String,Integer> map = new HashMap<>();

            for(int d=0;d<N;d++){
                String[] s = br.readLine().split(" ");
                String str = s[1];
                map.put(str,map.getOrDefault(str,0)+1);
            }

            int ans = 1;
            for (int val : map.values())
                ans *= val + 1;
            sb.append(ans-1+"\n");


        }
        System.out.println(sb.toString());
    }
}
