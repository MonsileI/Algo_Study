package Algorithm_eighth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_17219_비밀번호찾기_Silver_4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String,String> map = new HashMap<>();
        for(int i=0;i<N;i++){
            String[]tmp = br.readLine().split(" ");
            map.put(tmp[0],tmp[1]);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            sb.append(map.get(br.readLine())+"\n");
        }
        System.out.println(sb.toString());
    }
}
