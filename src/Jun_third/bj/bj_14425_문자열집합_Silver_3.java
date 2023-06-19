package Jun_third.bj;

import java.util.*;
import java.io.*;
public class bj_14425_문자열집합_Silver_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        int answer = 0;
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<N;i++) map.put(br.readLine(),0);
        for(int i=0;i<M;i++){
            String check = br.readLine();
            if(map.containsKey(check)) answer++;
        }
        System.out.println(answer);
    }
}
