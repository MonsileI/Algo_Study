package Algorithm_twelveth_week_2023_09.bj;

import java.util.*;
import java.io.*;
public class bj_29754_세상에는많은유튜버가있고그중에서버츄얼유튜버도존재한다_Silver_1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        TreeMap<String,Integer> map = new TreeMap<>();
        Map<String,Integer> cntMap = new HashMap<>();
        for(int i=0;i<N;i++){
            String tmp[] = br.readLine().split(" ");
            if(M<Integer.parseInt(tmp[1])) continue;
            int time = calc(tmp[2],tmp[3]);
            if(!map.containsKey(tmp[0])){
                map.put(tmp[0],0);
            }
            if(!cntMap.containsKey(tmp[0])){
                cntMap.put(tmp[0],0);
            }
            cntMap.put(tmp[0],cntMap.get(tmp[0])+1);
            map.put(tmp[0],map.get(tmp[0])+time);
        }
        StringBuilder sb = new StringBuilder();
        for(String key : map.keySet()){
            if(4<cntMap.get(key)&&3599<map.get(key)) sb.append(key+"\n");
        }
        if(sb.toString().isEmpty()) System.out.println(-1);
        else System.out.println(sb.toString());

    }
    static int calc(String start,String end){
        int time = 0;

        String[]tmp = start.split(":");
        int sMin = Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
        tmp = end.split(":");
        int eMin = Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
        return eMin - sMin;
    }
}
