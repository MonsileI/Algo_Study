package Algorithm_second_week_2023_07;

import java.io.*;
import java.util.*;

public class bj_25757_임스와함께하는미니게임_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<N;i++){
            String str = br.readLine();
            if(!map.containsKey(str)) map.put(str,0);
        }
        int size = map.size();
        int answer = 0;
        switch(game){
            case "Y": answer = size;
                break;
            case "F": answer = size/2;
                break;
            case "O": answer = size/3;
                break;
        }

        System.out.println(answer);

    }
}
