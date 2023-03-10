package Febrary_third;

import java.util.*;
import java.io.*;
public class bj_1062_가르침_Gold_4 {

    static int N,K;
    static String[]words;

    static boolean[]alpha;

    public static void main(String[] args) throws Exception {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if(K<5) {System.out.println(0); return; };
        alpha = new boolean[26];
        //anta tica a n t i c
        alpha['a'-'a'] = true; alpha['n'-'a'] = true; alpha['t'-'a'] = true; alpha['i'-'a'] = true; alpha['c'-'a'] = true;





    }
}
