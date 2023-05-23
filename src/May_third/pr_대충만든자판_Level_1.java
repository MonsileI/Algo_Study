package May_third;

import java.util.*;
public class pr_대충만든자판_Level_1 {
    public static void main(String[] args) {
        String[]keymap = {"AGZ","BSSS"};  String[]targets = {"ASA","BGZ"};
        int[]answer = new int[targets.length];
        Map<Character,Integer> map = new HashMap<>();
        int size = keymap.length;

        for(int i=0;i<size;i++){

            String key = keymap[i];

            for(int j=0;j<key.length();j++){
                char ch = key.charAt(j);
                if(map.containsKey(ch)){
                    if(j+1<map.get(ch)) map.put(ch,j+1);
                    continue;
                }
                map.put(ch,j+1);
            }

        }
        size = targets.length;
        for(int i=0;i<size;i++){
            String str = targets[i];
            int sum = 0;
            boolean flag = false;
            InnerLoop:
            for(int j=0;j<str.length();j++){
                char ch = str.charAt(j);
                if(!map.containsKey(ch)) {flag = true; break InnerLoop;};
                sum += map.get(ch);
            }
            if(flag) answer[i] = -1;
            else answer[i] = sum;
        }
        System.out.println(Arrays.toString(answer));
    }
}
