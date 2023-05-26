package May_third;

import java.util.*;
public class pr_달리기경주_Level_1 {
    public static void main(String[] args) {
        String []Players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        String[] answer = new String[Players.length];

        Map<String,Integer> map = new HashMap<>();
        Map<Integer,String> treeMap = new TreeMap<>();

        int size = Players.length;

        for(int i=0;i<size;i++){
            String name = Players[i];
            map.put(name,i+1);
            treeMap.put(i+1,name);
        }

        size = callings.length;

        for(int i=0;i<size;i++){
            String name = callings[i];
            int now = map.get(name);

            String loser = treeMap.get(now-1);

            //map  갱신
            map.put(name,now-1);
            map.put(loser,now);

            //map1 갱신
            treeMap.put(now-1,name);
            treeMap.put(now,loser);

        }

        System.out.println(treeMap);

        int idx = 0;
        for(int index : treeMap.keySet()){
            answer[idx++] = treeMap.get(index);
        }

    }
}
