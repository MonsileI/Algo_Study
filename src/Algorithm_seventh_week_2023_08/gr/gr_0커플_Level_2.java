package Algorithm_seventh_week_2023_08.gr;

import java.util.*;
import java.io.*;
public class gr_0커플_Level_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer,int[]> map = new HashMap<>();
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            if(!map.containsKey(Math.abs(num))){
                map.put(Math.abs(num),new int[]{num,0});
            }else{
                map.get(Math.abs(num))[1] = num;
            }
        }
        int answer = 0;
        for(int num : map.keySet()){
            if(map.get(num)[1]==0) answer += map.get(num)[0];
        }
        System.out.println(answer);
    }
}
