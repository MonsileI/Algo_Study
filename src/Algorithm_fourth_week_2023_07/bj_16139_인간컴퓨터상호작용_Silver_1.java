package Algorithm_fourth_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_16139_인간컴퓨터상호작용_Silver_1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Map<Character,List<Integer>> map = new HashMap<>();
        int size =str.length();
        for(int i=0;i<size;i++){
            char ch = str.charAt(i);
            if(!map.containsKey(ch)) map.put(ch,new ArrayList<>());
            map.get(ch).add(i);
        }
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<TC;i++){
            st = new StringTokenizer(br.readLine()," ");
            char ch = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken()); int end = Integer.parseInt(st.nextToken());
            int answer = 0;
            if(!map.containsKey(ch)) {
                sb.append(0).append("\n");
                continue;
            }
            for(int idx : map.get(ch)) if(start<=idx && idx<=end)answer++;
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
}
