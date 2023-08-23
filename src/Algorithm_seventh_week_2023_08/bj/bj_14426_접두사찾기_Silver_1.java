package Algorithm_seventh_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_14426_접두사찾기_Silver_1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String,Integer> map = new HashMap<>();
        for(int d =0;d<N;d++){
            String str = br.readLine();
            int size =str.length();
            for(int i=0;i<size;i++){
                String s = str.substring(0,i+1);
                if(!map.containsKey(s)){
                    map.put(s,0);
                }
            }
        }
        int answer = 0;
        for(int d=0;d<M;d++){
            String str =br.readLine();
            if(map.containsKey(str)) answer++;
        }
        System.out.println(answer);
    }
}
